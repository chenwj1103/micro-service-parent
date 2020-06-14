package com.chenwj.microservice.helloconsumerfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 这里hello-service大小写都可以，默认会转成大写
 *
 * @author :  chen weijie
 * @Date: 2020-06-14 19:35
 */
@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("hello")
    String hello(@RequestParam(value = "name") String name);

}
