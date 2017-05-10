package com.github.seanyinx.solid.alert.service;

public class AlertService {

    private final int threshold;

    public AlertService(int threshold) {
        this.threshold = threshold;
    }

    String process(Event event, String actionType) {
        int result = doSomeWork(event);

        if (result > threshold) {
            if ("email".equals(actionType)) {
                return sendMail(event);
            } else if ("text".equals(actionType)) {
                return sendText(event);
            } else {
                throw new IllegalArgumentException("No such action " + actionType);
            }
        }
        return "No alert required";
    }

    private int doSomeWork(Event event) {
        return event.value();
    }

    private String sendMail(Event event) {
        return "Alert email sent with event " + event.name();
    }

    private String sendText(Event event) {
        return "Alert text sent with event " + event.name();
    }
}
