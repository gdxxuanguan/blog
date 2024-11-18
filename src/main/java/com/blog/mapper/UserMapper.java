package com.blog.mapper;

import com.blog.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 22673
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-11-15 18:33:05
* @Entity com.blog.domain.User
*/
public interface UserMapper extends BaseMapper<User> {
    public User selectUserByUsername(String username);
}




