package com.github.seanyinx.solid.event.worker;

import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.ServiceProvider;

public class ServiceProviderUriBuilder<T> implements UriBuilder<T> {
  private final ServiceProvider<T> serviceProvider;

  public ServiceProviderUriBuilder(ServiceProvider<T> serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  @Override
  public String buildUri() throws Exception {
    ServiceInstance<T> instance = serviceProvider.getInstance();
    return instance.buildUriSpec();
  }
}
