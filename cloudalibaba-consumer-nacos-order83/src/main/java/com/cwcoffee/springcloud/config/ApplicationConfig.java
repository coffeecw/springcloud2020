package com.cwcoffee.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author cw
 * @Date 2020/06/28 14:57
 */
@Configuration
public class ApplicationConfig {

    @LoadBalanced//开启restTemplate的负载均衡  不加这个注解会报UnknowHostException
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
