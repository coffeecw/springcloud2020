package com.cwcoffee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author cw
 * @Date 2020/07/01 13:26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulMainOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulMainOrder80.class,args);
    }
}
