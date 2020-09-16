package com.itpro.blog.models.entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BlogPost {

    private long id;
    private String title;
    private String content;

    // @Autowired
    // private BlogPostMetaData metaData;
    // private BlogPostMetaData metaData = new BlogPostMetaData();

    public BlogPost() {
        System.out.println("BlogPost instance created");
        // this.metaData = externalMetaData;
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

//    public BlogPostMetaData getMetaData() {
//        return metaData;
//    }
//
//    public void setMetaData(BlogPostMetaData metaData) {
//        this.metaData = metaData;
//    }
}
