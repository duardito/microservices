package com.buy.feignClients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("beatifull")
public interface RemoteFeignClient {

    @RequestMapping(value="/service-client/{name}", method = RequestMethod.GET)
    String serviceInstancesByApplicationName(@PathVariable(value = "name") String name);

}
