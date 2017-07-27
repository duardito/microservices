package com.buy.BalancedFeign;

import com.buy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RibbonClient(name = "beatifull-v1", configuration = MyServerList.class)
public class RibbonClientTest {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    private static final String BEATIFULL = "beatifull";

    public String execute(String name) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("name", name);

        String url = String.format("http://%s/service-client/{name}", BEATIFULL);

        String greeting = this.restTemplate.getForObject(url, String.class, params);
        return String.format("%s, %s!", greeting, name);
    }

    public User executePojo(String name) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("name", name);
        String url = String.format("http://%s/service-client/{name}", BEATIFULL);
        User greeting = this.restTemplate.getForObject(url, User.class, params);
        return greeting;
    }

}
