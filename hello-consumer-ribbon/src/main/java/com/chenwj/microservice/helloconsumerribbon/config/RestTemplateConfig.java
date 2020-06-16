package com.chenwj.microservice.helloconsumerribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * @author :  chen weijie
 * @Date: 2020-06-14 19:13
 */
@Configuration
public class RestTemplateConfig {

    @Bean(name = "restTemplate")
    @LoadBalanced
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }

    @Bean
    @Primary
    public RestTemplate primaryRestTemplate(){
        return new RestTemplate();
    }
}
