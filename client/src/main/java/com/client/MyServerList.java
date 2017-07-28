package com.client;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

import java.util.Arrays;
import java.util.List;

public class MyServerList implements ServerList<Server> {

    @Override
    public final List<Server> getUpdatedListOfServers() {
        return Arrays.asList(new Server("192.168.99.100", 8486));
    }

    @Override
    public final List<Server> getInitialListOfServers() {
        return Arrays.asList(new Server("192.168.99.100", 8486));
    }
}