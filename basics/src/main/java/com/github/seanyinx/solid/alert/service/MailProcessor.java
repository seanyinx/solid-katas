package com.github.seanyinx.solid.alert.service;

public class MailProcessor implements EventProcessor {
  @Override
  public String process(Event event) {
    return "Alert email sent with event " + event.name();
  }
}
