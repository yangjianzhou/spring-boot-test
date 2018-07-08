package com.iwill.service;

import com.iwill.dto.User;
import com.iwill.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
/*
    @Reference(lazy = true)
    private IProductService productService ;*/

    public User getUserByUserId(Long userId) {
      //  String  productName = productService.getProductName(1234L);
        List<User> list = userMapper.selectAll();
        return userMapper.selectByUserId(userId);
    }

}
