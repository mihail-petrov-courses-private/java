package com.mihailpetrov.model;

public class User {

    private String username;
    private int age;
    private String email;

    public User(String username, int age, String email) {
        this.username = username;
        this.age = age;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
}
