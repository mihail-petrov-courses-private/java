package com.itpro.blog;

import com.itpro.blog.config.ProviderEnum;
import com.itpro.blog.factory.MailProviderFactory;
import com.itpro.blog.implenmentation.EmailSender;
import com.itpro.blog.models.entity.BlogPost;
import com.itpro.blog.models.provider.MailChimpProvider;
import com.itpro.blog.singleton.SingletonBlogPost;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BlogApplication {

	private static  EmailSender emailSenerService;

	public BlogApplication() {
		this.emailSenerService = new EmailSender(MailProviderFactory.provide(ProviderEnum.MAILCHIMP));
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext contenxt = SpringApplication.run(BlogApplication.class, args);

		/*
		System.out.println("Hello Spring Framework");
		SingletonBlogPost homeBlogPost = SingletonBlogPost.getInstance();
		homeBlogPost.setContent("* 1 | This is blog post about my Home");

		SingletonBlogPost saleBlogPost = SingletonBlogPost.getInstance();
		homeBlogPost.setContent("* 2 | This is blog post about sell");


		System.out.println(homeBlogPost.getContent());
		*/

		/*
		BlogPost blogPostIntro = contenxt.getBean(BlogPost.class);
		blogPostIntro.setContent("* 1 | This is my first post");

		BlogPost blogPostContent = contenxt.getBean(BlogPost.class);
		blogPostContent.setContent("* 2 | This is my main content post");

		 */

		// ??? 1. Mihail Pwetrov
		// ??? 2. Exception
		// System.out.println(blogPostContent.getMetaData().getAuthor());
	}
}