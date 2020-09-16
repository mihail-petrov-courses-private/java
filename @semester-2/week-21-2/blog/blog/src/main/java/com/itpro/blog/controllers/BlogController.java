package com.itpro.blog.controllers;

import com.itpro.blog.models.entity.BlogPost;
import com.itpro.blog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/blog")
public class BlogController {

    private BlogPostRepository repository;

    public BlogController(BlogPostRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path        = "/",
                produces    = "application/json")
    public List<BlogPost> getAllBlogPost() {
        return repository.getAllBlogPost();
    }

//    @GetMapping(path        = "/",
//            produces    = "application/json")
//    public BlogPost getBlogPost() {
//        return repository.getBlogPost();
//    }
}
