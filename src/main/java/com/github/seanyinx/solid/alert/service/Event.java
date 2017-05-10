package com.github.seanyinx.solid.alert.service;

public class Event {

    private final int value;
    private final String name;

    public Event(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int value() {
        return value;
    }

    public String name() {
        return name;
    }
}
