package com.chenwj.microservice.helloconsumerribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * 负载策略
 * @author :  chen weijie
 * @Date: 2020-06-16 14:33
 */
//@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
