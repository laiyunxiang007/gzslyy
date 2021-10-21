package com.gzslyy.webserviceserver.service;


import com.gzslyy.webserviceserver.HelloService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@Component
@WebService(name = "HelloService",  //暴露服务器名称
        targetNamespace = "http://webservice.gzslyy.com", //命名空间
        endpointInterface = "com.gzslyy.webserviceserver.HelloService")  //接口地址
public class HelloServiceImpl implements HelloService {
    @Override
    public String get(String a) {
        return a;
    }
}
