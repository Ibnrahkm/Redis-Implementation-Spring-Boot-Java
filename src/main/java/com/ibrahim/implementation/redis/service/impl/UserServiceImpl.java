package com.ibrahim.implementation.redis.service.impl;

import com.google.gson.Gson;
import com.ibrahim.implementation.redis.entites.User;
import com.ibrahim.implementation.redis.redis.CacheNames;
import com.ibrahim.implementation.redis.redis.CustomKeyGenerator;
import com.ibrahim.implementation.redis.repositories.UserRepository;
import com.ibrahim.implementation.redis.response.Response;
import com.ibrahim.implementation.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @CachePut(value = CacheNames.USER_LIST, keyGenerator = "customKeyGenerator", cacheManager = "cacheManager")
    @Override
    public Response addUser(User user) {
        System.out.println("entered into addUser function");
        Response response = new Response(false, "failed to add user", "");
        try {
            user = userRepository.save(user);
            if (user.getId() > 0) {
                response.setMessage("successful");
                response.setData(user);
                response.setStatus(true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @Override
    @Cacheable(value = CacheNames.USER_LIST, keyGenerator = "customKeyGenerator", cacheManager = "cacheManager")
    public Response getUserList() {
        System.out.println("entered into getUserList function");
        Response response = new Response(false, "failed to fetch users", "");
        try {
            response.setMessage("successful");
            response.setData(userRepository.findAll());
            response.setStatus(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @Override
    public Response deleteUser(User user) {
        return null;
    }

    @Override
    public Response updateUser(User user) {
        return null;
    }
}
