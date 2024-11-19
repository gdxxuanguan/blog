package com.blog.service;

import com.blog.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
* @author 22673
* @description 针对表【user】的数据库操作Service
* @createDate 2024-11-15 18:33:05
*/
public interface UserService extends IService<User> {
    User selectUserByUsername(String username);

    List<User> selectAll(User user);

    PageInfo<User> selectPage(User user, Integer pageNum, Integer pageSize);
}
