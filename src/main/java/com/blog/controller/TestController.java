package com.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.blog.domain.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    UserService userService;

    @GetMapping("/test")
    public String test(){

        List<User> list = userService.list();
        return list.toString();
    }


}