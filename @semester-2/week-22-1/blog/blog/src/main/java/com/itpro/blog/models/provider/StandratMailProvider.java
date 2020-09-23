package com.itpro.blog.models.provider;

import com.itpro.blog.interfaces.MailProvider;

public class StandratMailProvider implements MailProvider {

    @Override
    public void send() {
        System.out.println("Send MAIL");
    }
}
