package com.esample.springrest.controller;


import com.esample.springrest.model.UserInputRequest;
import com.esample.springrest.response.UserFetchResponse;
import com.esample.springrest.response.UserResponse;
import com.esample.springrest.service.EmailService;
import com.esample.springrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/users")
public class UserController {

    @Autowired(required = true)
    private UserService userService;

    @PostMapping("/signup")
    public UserResponse signUp(@RequestBody UserInputRequest userInputRequest) {
        return  userService.signUp(userInputRequest);
    }

    @GetMapping("/fetchdata")
    public UserFetchResponse findByUserName(@RequestParam("userName") String userName) {
        return userService.findByUserName(userName);
    }

}
