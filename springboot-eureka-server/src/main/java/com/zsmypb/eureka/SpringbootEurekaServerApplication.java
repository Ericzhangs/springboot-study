package com.zsmypb.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka注册中心
 * 	1、配置eureka信息(application.yml)
 * 	2、启用@EnableEurekaServer
 * @author zhangs
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringbootEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEurekaServerApplication.class, args);
	}

}
