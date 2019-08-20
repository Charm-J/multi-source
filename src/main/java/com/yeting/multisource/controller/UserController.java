package com.yeting.multisource.controller;

import com.yeting.multisource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DJ
 * @date 2019/8/7 16:02
 */
@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/exchange")
    public int exchangeUsers() throws Exception {
       return userService.exchangeUsers();
    }



}
