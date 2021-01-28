package com.itpro.blog;

import com.itpro.blog.config.ProviderEnum;
import com.itpro.blog.factory.MailProviderFactory;
import com.itpro.blog.implenmentation.EmailSender;
import com.itpro.blog.models.provider.MailChimpProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApplication {

	private static  EmailSender emailSenerService;

	public BlogApplication() {
		this.emailSenerService = new EmailSender(MailProviderFactory.provide(ProviderEnum.MAILCHIMP));
	}

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);

		System.out.println("Hello Spring Framework");

		emailSenerService.send();
	}
}