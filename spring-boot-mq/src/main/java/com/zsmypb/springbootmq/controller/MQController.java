package com.zsmypb.springbootmq.controller;

import com.zsmypb.springbootmq.service.MQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangs.
 * @date 2020/3/5.
 */
@RestController
public class MQController {

    @Autowired
    MQService service;

    @RequestMapping("/createExchange")
    public String createExchange(@RequestParam String name) {
        return service.createQueue(name);
    }

    @RequestMapping("/send")
    public String send(@RequestParam String message) {
        return service.sendQueue(message);
    }

    @RequestMapping("/receive")
    public String receive() {
        return service.receiverQueue();
    }


}
