package com.itpro.blog.factory;

import com.itpro.blog.config.ProviderEnum;
import com.itpro.blog.interfaces.MailProvider;
import com.itpro.blog.models.provider.CompanyMailProvider;
import com.itpro.blog.models.provider.MailChimpProvider;
import com.itpro.blog.models.provider.StandratMailProvider;

public class MailProviderFactory {

    public static MailProvider provide(ProviderEnum providerConfig) {

        if(providerConfig == ProviderEnum.MAILCHIMP) {
            return new MailChimpProvider();
        }

        if(providerConfig == ProviderEnum.COMPANY) {
            return new CompanyMailProvider();
        }

        return new StandratMailProvider();
    }


}
