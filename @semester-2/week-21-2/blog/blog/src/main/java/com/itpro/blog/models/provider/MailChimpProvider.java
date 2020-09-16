package com.itpro.blog.models.provider;

import com.itpro.blog.interfaces.MailProvider;

public class MailChimpProvider implements MailProvider {
    @Override
    public void send() {
        System.out.println("Send throw MAIL CHIMP");
    }
}
