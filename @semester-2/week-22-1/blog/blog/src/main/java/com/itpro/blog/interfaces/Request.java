package com.itpro.blog.interfaces;

public abstract class Request {

    protected String location;
    protected String destination;
    protected String sender;
    protected String level;

    public abstract  void send();

    public abstract void receive();
}
