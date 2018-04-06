package com.example.demo.controller;

import com.example.demo.convert.GenderEnum;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenhe on 2018/3/5.
 */
@RestController
public class ConvertController {

    @RequestMapping("converttest/{name}/{sex}")
    public String test(@PathVariable("name") String name, @PathVariable("sex") GenderEnum sex){
        return "name="+name+",sex="+sex.toString();
    }
}

