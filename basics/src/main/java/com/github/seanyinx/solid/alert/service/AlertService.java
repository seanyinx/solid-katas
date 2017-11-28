package com.github.seanyinx.solid.alert.service;

public class AlertService {

  private final int threshold;

  public AlertService(int threshold) {
    this.threshold = threshold;
  }

  String process(EventProcessor processor, Event event) {
    int result = doSomeWork(event);
    if (result > threshold) {
      return processor.process(event);
    }
    return "No alert required";
  }

  private int doSomeWork(Event event) {
    return event.value();
  }
}
