package com.zsmypb.springboot01.config.scan;

@NRpcServer(name="PersonService")
public class PersonService {

    public String getName(){
        return "helloword";
    }
}
