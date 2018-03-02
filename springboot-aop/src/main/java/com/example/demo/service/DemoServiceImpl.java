package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by chenhe on 2018/2/23.
 */
@Service
public class DemoServiceImpl implements DemoService{
    Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    public void test(String text) {
        logger.info("test方法执行了,text = {}",text);
    }

    public String test2(){
        logger.info("test2方法执行了");
        return "hello world";
    }

    public void test3() throws Exception {
        logger.info("test3方法执行了");
        throw new Exception("test3 方法报错");
    }
}
