package com.chenwj.microservice.helloconsumerribbonhystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author :  chen weijie
 * @Date: 2020-06-14 20:11
 */
@Service
public class HelloService {

    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String hello(String name) {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello?name=" + name, String.class).getBody();
    }


    @HystrixCommand(fallbackMethod = "fallback2", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String hello2(String name) {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello?name=" + name, String.class).getBody();
    }

    public String fallback(String name) {
        return "hello, hystrix       === fail name:" + name;
    }

    public String fallback2(String name) {
        return "hello, hystrix       === fail name, timeout:2000:" + name;
    }
}
