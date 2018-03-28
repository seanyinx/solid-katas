package com.github.seanyinx.solid.user;

import java.util.Date;

public class User {
    private final String username;
    private final DateGenerator dateGenerator;
    private Date lastLoginTime;

    public User(String username) {
        this.username = username;
        this.dateGenerator = new DateGenerator();
        this.lastLoginTime = dateGenerator.newDate();
    }

    void login() {
        lastLoginTime = dateGenerator.newDate();
    }
}
