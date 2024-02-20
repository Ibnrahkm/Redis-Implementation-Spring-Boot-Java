package com.ibrahim.implementation.redis.controller;

import com.google.gson.Gson;
import com.ibrahim.implementation.redis.entites.User;
import com.ibrahim.implementation.redis.response.Response;
import com.ibrahim.implementation.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    UserService service;

    @PostMapping("/addUser")
    public Response addUser(@RequestBody String data) {
        return service.addUser(new Gson().fromJson(data, User.class));
    }

    @GetMapping("/getUsers")
    public Response getUsers() {
        return service.getUserList();
    }
}
