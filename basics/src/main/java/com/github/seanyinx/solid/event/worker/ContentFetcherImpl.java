package com.github.seanyinx.solid.event.worker;

public class ContentFetcherImpl implements ContentFetcher {
  @Override
  public String fetch(String uri) {
    return String.format("{\"uri\":\"%s\"}", uri);
  }
}
