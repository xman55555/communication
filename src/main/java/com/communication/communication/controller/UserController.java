package com.communication.communication.controller;

import com.communication.communication.Utils.Utils;
import com.communication.communication.entity.User;
import com.communication.communication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    @ResponseBody
    public User toIndex(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        return user;
    }
    @RequestMapping("/insertUser")
    @ResponseBody
    public User insertUser(HttpServletRequest request, Model model){
        User user = new User();
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setId(Utils.generateTimeStringId());
        userService.addUser(user);
        return user;
    }

    @RequestMapping("/toRegisterUser")
    public String registerUser(){
        return "user/registerUser";
    }
}