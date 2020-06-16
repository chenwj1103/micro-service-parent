package com.chenwj.microservice.helloconsumerribbon.controller;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author :  chen weijie
 * @Date: 2020-06-14 19:11
 */
@RestController
@EnableDiscoveryClient
public class HelloController {

    @Resource
    @LoadBalanced //如果有多个客户端需要加此注解，否则可以省略
    private RestTemplate restTemplate;

    /**
     * HELLO-SERVICE 为注册到eureka注册中心的名字
     * @param name
     * @return
     */
    @RequestMapping("hello")
    public ResponseEntity<String> hello(String name) {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello?name=" + name, String.class);
    }

}
