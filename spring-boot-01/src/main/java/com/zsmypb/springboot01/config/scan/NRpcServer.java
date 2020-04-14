package com.zsmypb.springboot01.config.scan;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NRpcServer {
    //服务的名称,用来RPC的时候调用指定名称的 服务
    String name() default "";
    String value() default "";
}
