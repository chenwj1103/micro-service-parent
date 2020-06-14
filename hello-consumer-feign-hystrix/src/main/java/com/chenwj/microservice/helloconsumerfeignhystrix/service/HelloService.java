package com.chenwj.microservice.helloconsumerfeignhystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author :  chen weijie
 * @Date: 2020-06-14 20:35
 */
@FeignClient(value = "hello-service", fallback = HelloServiceFallBack.class)
public interface HelloService {

    @RequestMapping("hello")
    String hello(@RequestParam(value = "name") String name);

}
