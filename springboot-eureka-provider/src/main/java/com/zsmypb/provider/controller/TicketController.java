package com.zsmypb.provider.controller;

import com.zsmypb.provider.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangs.
 * @date 2020/3/17.
 */
@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/getTicket")
    public String getTicket() {
        return ticketService.getTicket();
    }
}
