package com.zsmypb.springboot01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangs.
 * @date 2020/3/16.
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("world")
    public String hello() {
        return "hello world dd";
    }
}
