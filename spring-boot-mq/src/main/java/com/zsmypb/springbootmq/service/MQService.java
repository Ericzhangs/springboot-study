package com.zsmypb.springbootmq.service;

import com.zsmypb.springbootmq.bean.User;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author zhangs.
 * @date 2020/3/5.
 */
@Service
public class MQService {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    public String createQueue(String name) {
//        BindingBuilder.bind(new Queue("amqpAdmin.queue")).to(new DirectExchange("amqpAdmin.exchange")).with("");
        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue"));
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE, "amqpAdmin.exchange", name, null));
        return "create OK!";
    }

    public String sendQueue(String message) {
        User user = User.builder().name(message).password("123456").birthday(new Date()).build();
        // 向队列中发送信息
        rabbitTemplate.convertAndSend("zhang.direct", "queue", user);
        return "ok";
    }

    /**
     * 主动获取队列信息
     * @return
     */
    public String receiverQueue() {
        Object queue = rabbitTemplate.receiveAndConvert("queue");
        return queue != null ? queue.toString() : "没了";
    }

    /**
     * 实时监听队列 自动获取队列信息
     * @param user
     */
    @RabbitListener(queues = {"queue"})
    public void listenerQueue(User user) {
        System.out.println("新用户：" + user.toString());
    }
}
