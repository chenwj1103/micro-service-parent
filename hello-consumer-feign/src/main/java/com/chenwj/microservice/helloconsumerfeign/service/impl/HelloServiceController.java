package com.chenwj.microservice.helloconsumerfeign.service.impl;

import com.chenwj.microservice.helloconsumerfeign.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author :  chen weijie
 * @Date: 2020-06-14 19:45
 */
@RestController
public class HelloServiceController {

    @Resource
    private HelloService helloService;

    @RequestMapping("hello")
    public String hello(String name){
        return helloService.hello(name);
    }


}
