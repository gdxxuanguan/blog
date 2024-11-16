package com.blog.controller;

import com.blog.Utils.ResultUtil;
import com.blog.domain.Result;
import com.blog.domain.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        userService.save(user);
        return ResultUtil.success();
    }

    @GetMapping("/findall")
    public Result findAll() {
        return ResultUtil.success(userService.list());
    }


}
