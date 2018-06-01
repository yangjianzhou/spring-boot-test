package com.iwill.controller;

import com.iwill.dto.User;
import com.iwill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/get-user-info", method = RequestMethod.GET)
    public String getUserInfo(@RequestParam("userId") String userId) {
        User user = userService.getUserByUserId(Long.valueOf(userId));
        return "SUCCESS";
    }
}
