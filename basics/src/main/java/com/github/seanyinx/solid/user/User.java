package com.github.seanyinx.solid.user;

import java.util.Date;

public class User {
    private final String username;
    private Date lastLoginTime;

    public User(String username) {
        this.username = username;
        this.lastLoginTime = new Date();
    }

    void login() {
        lastLoginTime = new Date();
    }
}
