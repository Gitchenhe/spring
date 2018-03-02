package com.example.demo;

import com.example.demo.redis.RedisDemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes = SpringbootCacheApplication.class, webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT) // 指定我们SpringBoot工程的Application启动类
public class SpringbootCacheApplicationTests {

	@Autowired
	RedisDemoService redisDemoService;
	@Test
	public void contextLoads() {
		assert redisDemoService.add("name","哈哈") == true;
	}

}
