package com.itpro.blog.models.entity;
import com.itpro.blog.util.Sequance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class BlogPost {

    private int id;
    private String title;
    private String content;

    public BlogPost(String title, String content) {

        this.id    = Sequance.next();
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
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
