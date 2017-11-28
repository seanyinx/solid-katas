package com.github.seanyinx.solid.alert.service;

public class TextProcessor implements EventProcessor {
  @Override
  public String process(Event event) {
    return "Alert text sent with event " + event.name();
  }
}
