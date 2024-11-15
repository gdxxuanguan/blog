package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.domain.User;
import com.blog.service.UserService;
import com.blog.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 22673
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-11-15 18:33:05
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




