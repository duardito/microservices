package com.client.controller;

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
}

