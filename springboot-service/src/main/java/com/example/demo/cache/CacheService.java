package com.example.demo.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by chenhe on 2018/3/2.
 */
@Service
public class CacheService {

    @Autowired
    RedisTemplate redisTemplate;

    public void set(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

}
