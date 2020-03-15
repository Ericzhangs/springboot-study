package com.zsmypb.springbootzkconsumer;

import com.zsmypb.springbootzkconsumer.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootZkConsumerApplicationTests {

	@Autowired
	UserService userService;

	@Test
	void contextLoads() {
		System.out.println(userService.hello());
	}

}
