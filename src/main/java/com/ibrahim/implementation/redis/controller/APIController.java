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

    @PostMapping("/updateUser")
    public Response updateUser(@RequestBody String data) {
        return service.updateUser(new Gson().fromJson(data, User.class));
    }

    @GetMapping("/getUser")
    public Response getUser(@RequestParam("id") String id) {
        return service.getUser(id);
    }


    @PostMapping("/deleteUser")
    public Response deleteUser(@RequestParam("id") String id) {
        return service.deleteUser(id);
    }

    @PostMapping("/getUsersByFilter")
    public Response getUsersByFilter(@RequestParam("balance") String balance) {
        return service.getUserListByFilter(balance);
    }

    @GetMapping("/getUsers")
    public Response getUsers() {
        return service.getUserList();
    }
}
