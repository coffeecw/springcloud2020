package com.cwcoffee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author cw
 * @Date 2020/07/10 10:59
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClient3377 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3377.class,args);
    }
}
