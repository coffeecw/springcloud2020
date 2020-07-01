package com.cwcoffee.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author cw
 * @Date 2020/07/01 14:32
 */
@Configuration
public class MySelfRule {
    //负载均衡替换为随机
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
