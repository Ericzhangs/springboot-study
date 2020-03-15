package com.zsmypb.springbootzkprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、将服务提供这注册到注册中心
 * 		1、引入dubbo和zookeeper相关依赖
 * 		2、配置dubbo的扫描包和注册中心地址
 * 		3、使用org.apache.dubbo.config.annotation.Service(@Service)发布服务
 */
@SpringBootApplication
public class SpringbootZkProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootZkProviderApplication.class, args);
	}

}
