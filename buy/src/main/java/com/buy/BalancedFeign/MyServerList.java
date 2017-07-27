package com.buy.BalancedFeign;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

import java.util.Arrays;
import java.util.List;


public class MyServerList implements ServerList<Server> {

    @Override
    public final List<Server> getUpdatedListOfServers() {
        // TODO do some fancy stuff here
        return Arrays.asList( new Server("localhost", 8080));
    }

    @Override
    public final List<Server> getInitialListOfServers() {
        return Arrays.asList( new Server("localhost", 8080));
    }
}