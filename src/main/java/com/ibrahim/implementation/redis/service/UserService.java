package com.ibrahim.implementation.redis.service;

import com.ibrahim.implementation.redis.entites.User;
import com.ibrahim.implementation.redis.response.Response;

public interface UserService {

    public Response addUser(User user);

    public Response getUserList();

    public Response deleteUser(User user);

    public Response updateUser(User user);
}
