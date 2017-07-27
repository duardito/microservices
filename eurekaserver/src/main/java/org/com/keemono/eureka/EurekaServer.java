package org.com.keemono.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EurekaServer.class, args);
    }
}
