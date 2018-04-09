package com.example.club.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.club.model.gen.UserEntity;
import com.example.club.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping(value="/user",method=RequestMethod.POST)
    Object user(@RequestBody String body) {
		JSONObject jsonNode = new JSONObject(body);
		int id = jsonNode.getInt("id");
        return userService.getUser(id);
    }
	@RequestMapping(value="/users")
    Object users() {
        return userService.getUsers();
    }
}
