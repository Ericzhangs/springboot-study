package com.zsmypb.algorithm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaAlgorithmApplicationTests {

	@Autowired
	AopTestService aopTestService;

	@Test
	void contextLoads() {
		String name = aopTestService.getName();
		System.out.println(name);
	}

}
