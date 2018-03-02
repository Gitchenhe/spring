package com.example.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by chenhe on 2018/3/1.
 */
@Controller
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequiresRoles("admin")
    @RequestMapping("/test")
    @ResponseBody
    public String test(String msg) {
        logger.info("收到请求,msg={}", msg);
        return msg;
    }

    @RequestMapping("/uid")
    @ResponseBody
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
    @RequestMapping("/set/{key}/{value}")
    @ResponseBody
    String set(HttpSession session,@PathVariable("key") String key,@PathVariable("value") String value) {
        session.setAttribute(key,value);
        return "OK";
    }
    @RequestMapping("/get/{key}")
    @ResponseBody
    String get(HttpSession session,@PathVariable("key") String key) {
        return session.getAttribute(key).toString();
    }
}
