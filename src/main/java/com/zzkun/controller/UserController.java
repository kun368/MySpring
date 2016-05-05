package com.zzkun.controller;

import com.zzkun.model.User;
import com.zzkun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller用于标注控制层组件
 * Created by kun on 2016/5/5.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginView")
    public String loginView(){
        return "login.jsp";
    }

    @RequestMapping("/login")
    public ModelAndView login(User user){
        ModelAndView mav = new ModelAndView();
        System.out.println(user.getUsername() + " " + user.getPassword());
        if(!userService.loginCheck(user)) {
            mav.setViewName("login.jsp");
            mav.addObject("errorMsg", "用户名或密码错误！");
        } else {
            mav.setViewName("success.jsp");
            mav.addObject("user", user);
        }
        return mav;
    }
}
