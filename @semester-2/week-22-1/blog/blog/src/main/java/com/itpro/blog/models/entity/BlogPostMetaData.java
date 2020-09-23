package com.itpro.blog.models.entity;

import org.springframework.stereotype.Component;

@Component
public class BlogPostMetaData {

    private String author;

    public BlogPostMetaData() {
        System.out.println("BlogPostMetaData init");
    }

    public String getAuthor() {
        return "Mihail Petrov";
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
