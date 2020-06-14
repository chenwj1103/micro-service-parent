package com.chenwj.microservice.servicezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 * *  @EnableEurekaClient为了结合eureka，调用注册在eureka中的服务，所以zuul这里也是作为eureka的客户端。
 * 当然这里也可以使用@EnableDiscoveryClient，可以发现@EnableEurekaClient注解实现包含了@EnableDiscoveryClient，
 * 这里只用来调用eureka服务的话，两个都可以使用，如果要使用其他的，比如consul，那就只能用@EnableDiscoveryClient了。
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }

}
