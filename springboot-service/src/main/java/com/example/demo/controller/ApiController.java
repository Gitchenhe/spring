package com.example.demo.controller;

import com.springboot.demo.DemoRequest;
import com.springboot.demo.DemoResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenhe on 2018/2/23.
 */
@RestController
public class ApiController {

    @RequestMapping("api")
    public DemoResponse test(@RequestBody DemoRequest request){
        DemoResponse response = new DemoResponse();
        response.setErrorCode("0");
        response.setData(request.getRequestData());
        return response;
    }
}
