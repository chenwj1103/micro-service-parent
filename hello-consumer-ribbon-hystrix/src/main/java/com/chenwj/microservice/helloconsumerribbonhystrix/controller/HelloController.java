package com.chenwj.microservice.helloconsumerribbonhystrix.controller;

import com.chenwj.microservice.helloconsumerribbonhystrix.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author :  chen weijie
 * @Date: 2020-06-14 20:14
 */
@RestController
public class HelloController {

    @Resource
    private HelloService helloService;

    @RequestMapping("hello")
    public String hello (String name) {
        return helloService.hello(name);
    }

    @RequestMapping("hello2")
    public String hello2 (String name) {

        return helloService.hello2(name);
    }

}
