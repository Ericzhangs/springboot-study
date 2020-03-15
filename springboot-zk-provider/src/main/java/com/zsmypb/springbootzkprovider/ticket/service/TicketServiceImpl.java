package com.zsmypb.springbootzkprovider.ticket.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author zhangs.
 * @date 2020/3/6.
 */
@Service
@Component
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicker() {
        return "《我和我的祖国》";
    }
}
