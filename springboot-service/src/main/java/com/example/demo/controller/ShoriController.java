package com.example.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by chenhe on 2018/3/2.
 */
@Controller
public class ShoriController {

    Logger logger = LoggerFactory.getLogger(ShoriController.class);

    @RequestMapping("login")
    @ResponseBody
    public String login(){
        logger.info("login");
        SecurityUtils.getSubject().hasRole("chenhe");
        return "请登录";
    }

    @RequestMapping("/dologin/{username}/{password}")
    @ResponseBody
    public String doLogin(@PathVariable("username") String name, @PathVariable("password") String password){
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name,password);
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()){
            usernamePasswordToken.setRememberMe(true);
            subject.login(usernamePasswordToken);
        }
        return "登录成功";
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "退出成功";
    }

    @RequestMapping("checkrole/{role}")
    @ResponseBody
    public boolean hasRole(@PathVariable("role") String role){
        Subject subject = SecurityUtils.getSubject();
        return subject.hasRole(role);
    }

    @RequestMapping("checkpermiss/{permiss}")
    @ResponseBody
    public String hasPermiss(@PathVariable("permiss") String permiss){
        Subject subject = SecurityUtils.getSubject();
        subject.checkPermission(permiss);
        return "OK";
    }
}
