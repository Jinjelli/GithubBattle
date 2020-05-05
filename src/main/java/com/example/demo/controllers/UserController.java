package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.User;
import com.example.demo.services.UserService;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
    @GetMapping("/user/{username1}/{username2}")
    public List<User> acceptForm2(@PathVariable("username1") String username1, @PathVariable("username2") String username2 ) {
        return userService.acceptForm2(username1, username2);
    }
    
    @GetMapping("/user/{username1}")
    public User acceptForm1(@PathVariable("username1") String username1) {
        return userService.acceptForm1(username1);
    }
    
}




