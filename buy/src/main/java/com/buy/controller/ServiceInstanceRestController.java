package com.buy.controller;

import com.buy.BalancedFeign.RibbonClientTest;
import com.buy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public @RestController
class ServiceInstanceRestController {

    @Autowired
    private RibbonClientTest remoteFeignClient;

    @RequestMapping("/service-buy/{applicationName}")
    public String serviceInstancesByApplicationName(@PathVariable String applicationName) {
        String val = remoteFeignClient.execute(applicationName);

        return val;
    }

    @RequestMapping("/service-buy/user/{applicationName}")
    public User serviceInstancesByApplication(
            @PathVariable String applicationName) {
        User val = remoteFeignClient.executePojo(applicationName);

        return val;
    }
}