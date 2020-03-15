package com.zsmypb.springbootzkconsumer.user.controller;

import com.zsmypb.springbootzkconsumer.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangs.
 * @date 2020/3/6.
 */
@RestController
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping("/getTicket")
    public String getTicket() {
        return service.hello();
    }
}
