package com.chenwj.microservice.helloconsumerfeignhystrix.service;

import org.springframework.stereotype.Component;

/**
 * @author :  chen weijie
 * @Date: 2020-06-14 20:36
 */
@Component
public class HelloServiceFallBack implements HelloService {

    @Override
    public String hello(String name) {
        return "hello, hystrix  == fail name : " + name;
    }
}
