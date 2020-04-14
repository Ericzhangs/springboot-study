package com.zsmypb.algorithm;

import com.zsmypb.algorithm.aop.AopInterface;
import org.springframework.stereotype.Service;

/**
 * @author zhangs.
 * @date 2020/4/13.
 */
@Service
public class AopTestService {

    @AopInterface(methodName = "getName")
    public String getName() {
        return "我是渣渣会";
    }
}
