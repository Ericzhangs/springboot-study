package com.zsmypb.springbootmq.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangs.
 * @date 2020/3/5.
 */
@Configuration
public class MyAMQPConfig {

    @Bean
    public MessageConverter messageConverter() {
        // 用与序列化bean (重写了RabbitTemplate中的MessageConverter)
        return new Jackson2JsonMessageConverter();
    }
}
