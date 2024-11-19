package com.blog.controller;

import com.blog.ResultEnum;
import com.blog.Utils.ResultUtil;
import com.blog.domain.Result;
import com.blog.domain.User;
import com.blog.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")//创建新用户
    public Result add(@RequestBody User user) {
        User dbuser=userService.selectUserByUsername(user.getUserName());
        if(dbuser!=null){
            return ResultUtil.error(ResultEnum.USER_IS_EXISTS.getCode(),ResultEnum.USER_IS_EXISTS.getMsg());
        }
        userService.save(user);
        return ResultUtil.success();
    }

    @DeleteMapping("/delete/{id}")//删除
    public Result delete(@PathVariable int id) {
        if(userService.getById(id)==null){
            return ResultUtil.error(ResultEnum.USER_NOT_EXIST.getCode(),ResultEnum.USER_NOT_EXIST.getMsg());
        }
        userService.removeById(id);
        return ResultUtil.success();
    }

    @DeleteMapping("/delete/batch") //批量删除
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        userService.removeBatchByIds(ids);
        return ResultUtil.success();
    }

    @PutMapping("/update")//更新用户信息
    public Result update(@RequestBody User user) {
        User dbuser=userService.getById(user.getUserId());
        if(dbuser!=null){
            return ResultUtil.error(ResultEnum.USER_NOT_EXIST.getCode(),ResultEnum.USER_NOT_EXIST.getMsg());
        }
        userService.updateById(user);
        return ResultUtil.success();
    }

    @GetMapping("/selectById/{id}")
    public Result findById(@PathVariable int id) {
        User user=userService.getById(id);
        if(user!=null){
            return ResultUtil.success(user);
        }else{
            return ResultUtil.error(ResultEnum.USER_NOT_EXIST.getCode(),ResultEnum.USER_NOT_EXIST.getMsg());
        }
    }

    @GetMapping("/selectAll")
    public Result findAll(User user) {
        List<User> userList=userService.selectAll(user);
        return ResultUtil.success(userList);
    }

//    分页查询
    @GetMapping("/selectPage")
    public Result selectPage(User user,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<User> page=userService.selectPage(user,pageNum,pageSize);
        return ResultUtil.success(page);
    }
}
