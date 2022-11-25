package com.formsecurity.formsecurity.controller;

import com.formsecurity.formsecurity.db.UserRepository;
import com.formsecurity.formsecurity.entity.User;
import com.formsecurity.formsecurity.model.UserModel;
import com.formsecurity.formsecurity.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/public")
public class PublicRestApiController {
    @Autowired
    AppService appService;
    @Autowired
    UserRepository userRepository;

    public PublicRestApiController(){}

    @GetMapping("test1")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("test2")
    public String test2(){
        return "API Test 2";
    }
@GetMapping("users")
    public List<User> users(){
        return userRepository.findAll();
}
@PostMapping("register")
    public User registerNewUser(@RequestBody UserModel userModel){
        return appService.registerUser(userModel);
}
    @GetMapping
    public List<User> registerNewUser(){
        return appService.getAllusers();
    }
}