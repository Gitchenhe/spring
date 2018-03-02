package com.example.demo.controller;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenhe on 2018/3/2.
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public String authException(UnauthorizedException e){
        return String.format("没有权限,message:[%s]",e.getMessage());
    }
}
