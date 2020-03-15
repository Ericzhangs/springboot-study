package com.zsmypb.springbootmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 * 	1、RabbitAutoConfiguration
 * 	2、自动配置了连接工厂 rabbitConnectionFactory
 * 	3、@EnableConfigurationProperties(RabbitProperties.class) RabbitProperties封装了RabbitMQ的配置
 * 	4、AmqpAdmin: RabbitMQ系统管理功能组件(用于创建或者删除交换器、队列、绑定关系)
 * 	5、RabbitTemplate: 提供了发送和接受消息接口
 * 	6、@EnableRabbit + @RabbitListener 开启监听消息队列内容功能
 */
@EnableRabbit
@SpringBootApplication
public class SpringBootMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMqApplication.class, args);
    }

}
