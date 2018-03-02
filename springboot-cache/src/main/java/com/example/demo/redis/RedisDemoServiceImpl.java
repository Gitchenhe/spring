package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by chenhe on 2018/3/2.
 */
@Service
public class RedisDemoServiceImpl implements RedisDemoService{
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public boolean add(String key, String value) {
        try{
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
