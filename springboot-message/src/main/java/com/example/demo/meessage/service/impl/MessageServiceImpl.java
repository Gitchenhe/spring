package com.example.demo.meessage.service.impl;

import com.springboot.demo.service.message.MessageService;

import java.util.Collections;

/**
 * Created by chenhe on 2018/3/4.
 */
public class MessageServiceImpl implements MessageService {
    @Override
    public boolean sendMessages(Collections topics, Object key, Object value, boolean createNotExist) {
        return false;
    }
}
