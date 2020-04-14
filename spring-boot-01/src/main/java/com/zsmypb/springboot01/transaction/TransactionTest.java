package com.zsmypb.springboot01.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangs.
 * @date 2020/4/14.
 */
@Service
public class TransactionTest {

    @Transactional(propagation = Propagation.REQUIRED)
    public String getTransaction() {
        return "getTransaction";
    }

}
