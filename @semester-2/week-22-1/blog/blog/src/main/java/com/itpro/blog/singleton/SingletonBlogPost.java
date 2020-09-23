package com.itpro.blog.singleton;

public class SingletonBlogPost {

    private SingletonBlogPost() {

    }

    private long id;
    private String title;
    private String content;

    private static SingletonBlogPost instanceReference = null;

    public static SingletonBlogPost getInstance() {

        if(instanceReference == null) {
            instanceReference =  new SingletonBlogPost();
        }

        return instanceReference;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
