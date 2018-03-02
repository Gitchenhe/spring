package com.example.demo;

import com.google.gson.Gson;
import com.springboot.demo.entity.DemoRequest;
import com.springboot.demo.entity.DemoResponse;
import com.springboot.demo.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	HelloService helloService;

	@Test
	public void contextLoads() {
		Gson gson = new Gson();
		Map map = new HashMap();
		map.put("name","陈贺");
		map.put("age",21);
		DemoRequest demoRequest = new DemoRequest();
		demoRequest.setServiceName("陈贺");
		demoRequest.setRequestData(gson.toJson(map));
		DemoResponse response = restTemplate.postForObject("http://localhost:9191/springboot-setvice/api",demoRequest,DemoResponse.class);

	}

}
