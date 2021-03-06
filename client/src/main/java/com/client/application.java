package com.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableCircuitBreaker
//@EnableFeignClients
//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class application {

    public static void main(String[] args) {
        SpringApplication.run(application.class, args);
    }
}


