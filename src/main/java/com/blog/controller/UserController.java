package com.blog.controller;

import com.blog.ResultEnum;
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
        User dbuser=userService.selectUserByUsername(user.getUserName());
        if(dbuser!=null){
            return ResultUtil.error(ResultEnum.USER_IS_EXISTS.getCode(),ResultEnum.USER_IS_EXISTS.getMsg());
        }
        userService.save(user);
        return ResultUtil.success();
    }

    @GetMapping("/findall")
    public Result findAll() {
        return ResultUtil.success(userService.list());
    }

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable int id) {
        return ResultUtil.success(userService.getById(id));
    }

}
