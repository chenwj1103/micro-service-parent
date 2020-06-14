package com.chenwj.microservice.helloconsumerfeignhystrix.controller;

import com.chenwj.microservice.helloconsumerfeignhystrix.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author :  chen weijie
 * @Date: 2020-06-14 20:45
 */
@RestController
public class HelloController {

    @Resource
    private HelloService helloService;

    @RequestMapping("hello")
    public String hello(String name) {
        return helloService.hello(name);
    }

}
