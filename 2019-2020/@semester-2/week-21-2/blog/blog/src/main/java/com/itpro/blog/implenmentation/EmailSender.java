package com.itpro.blog.implenmentation;

import com.itpro.blog.interfaces.MailProvider;

public class EmailSender {

    private MailProvider mailProviderReference;

    public EmailSender(MailProvider mailProviderReference) {
        this.mailProviderReference = mailProviderReference;
    }


    public void send() {
        this.mailProviderReference.send();
    }


}
