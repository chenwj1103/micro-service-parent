package com.chenwj.microservice.helloservice.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author :  chen weijie
 * @Date: 2020-06-14 17:41
 */
@RestController
public class HelloController {

    @Resource
    Environment environment;

    @RequestMapping("hello")
    public String hello(String name) throws InterruptedException {
        System.out.println("hello ,port:" + environment.getProperty("local.server.port"));
//        Thread.sleep(2000);
        return "hello, " + name;
    }
}
