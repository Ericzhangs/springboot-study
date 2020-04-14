package com.zsmypb.springbootzkconsumer.user.service;

import com.zsmypb.springbootzkutil.service.TicketService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author zhangs.
 * @date 2020/3/6.
 */
@Service
public class UserService {

    @Reference
    TicketService ticketService;

    public String hello() {
        String ticker = ticketService.getTicker();
        return "买到了:" + ticker;
    }
}
