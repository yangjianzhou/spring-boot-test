package com.iwill.mapper;

import com.iwill.dto.User;

import java.util.List;

public interface UserMapper {

    public List<User> selectAll();

    public User selectByUserId(Long userId) ;
}
