package com.zsmypb.springbootredis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
class SpringBootRedisApplicationTests {


    @Test
    void contextLoads() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

		String str = jedis.get("str");
		System.out.println(str);
	}

}
