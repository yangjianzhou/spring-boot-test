package com.iwill.service;

import com.iwill.mapper.UserMapper;
import com.iwill.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserByUserId(Long userId) {
        List<User> list = userMapper.selectAll();
        return userMapper.selectByUserId(userId);
    }

}
