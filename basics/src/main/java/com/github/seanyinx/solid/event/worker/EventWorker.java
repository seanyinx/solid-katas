package com.github.seanyinx.solid.event.worker;

import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.ServiceProvider;

public class EventWorker {
    private final ServiceProvider<Profile> serviceProvider;

    public EventWorker(ServiceProvider<Profile> serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String run() throws Exception {
        ServiceInstance<Profile> instance = serviceProvider.getInstance();
        String uri = instance.buildUriSpec();

        String json = fetch(uri);
        return process(json);
    }

    private String fetch(String uri) {
        return String.format("{\"uri\":\"%s\"}", uri);
    }

    private String process(String json) {
        return json;
    }
}
