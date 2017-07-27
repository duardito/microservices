package com.buy.BalancedFeign;

import com.buy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RibbonClient(name = "beatifull-service", configuration = RibbonConfiguration.class)
public class RibbonClientTest {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    public String execute(String name) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("name", name);

        String greeting = this.restTemplate.getForObject("http://beatifull/service-client/{name}", String.class, params);
        return String.format("%s, %s!", greeting, name);
    }

    public User executePojo(String name) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("name", name);

        User greeting = this.restTemplate.getForObject("http://beatifull/service-client/{name}", User.class, params);
        return greeting;
    }

}
