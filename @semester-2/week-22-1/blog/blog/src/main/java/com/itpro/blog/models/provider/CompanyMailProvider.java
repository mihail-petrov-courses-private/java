package com.itpro.blog.models.provider;

import com.itpro.blog.interfaces.MailProvider;

public class CompanyMailProvider implements MailProvider {


    @Override
    public void send() {
        System.out.println("Send SPECIAL COMPANY E_mail");
    }
}
