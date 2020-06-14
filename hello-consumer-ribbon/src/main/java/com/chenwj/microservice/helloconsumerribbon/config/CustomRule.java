package com.chenwj.microservice.helloconsumerribbon.config;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Configuration;

/**
 * @author :  chen weijie
 * @Date: 2020-06-14 23:18
 */
@Configuration
public class CustomRule implements IRule {

    @Override
    public Server choose(Object o) {
        return null;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {

    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return null;
    }
}
