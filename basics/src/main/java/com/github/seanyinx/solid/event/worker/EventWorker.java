package com.github.seanyinx.solid.event.worker;

public class EventWorker<T> {
  private final UriBuilder<T> builder;

  private final ContentFetcher fetcher;

  private final ContentProcessor processor;

  public EventWorker(UriBuilder<T> builder, ContentFetcher fetcher,
      ContentProcessor processor) {
    this.builder = builder;
    this.fetcher = fetcher;
    this.processor = processor;
  }

  public String run() throws Exception {
    return processor.process(fetcher.fetch(builder.buildUri()));
  }
}
