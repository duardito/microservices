package com.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceInstanceRestController {

    @RequestMapping("/service-client/{applicationName}")
    public User serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        User user = new User();
        user.setName(applicationName);
        return user;
    }

    @HystrixCommand(fallbackMethod = "fallbackGetUser")
    @RequestMapping("/service-client/fail/{applicationName}")
    public User serviceInstancesByFail(@PathVariable String applicationName) {
        throw new RuntimeException("Simulating downstream system failure");
    }

    public User fallbackGetUser(@PathVariable String applicationName) {
        User user = new User();
        user.setName("FAILED");
        return user;
    }
}

