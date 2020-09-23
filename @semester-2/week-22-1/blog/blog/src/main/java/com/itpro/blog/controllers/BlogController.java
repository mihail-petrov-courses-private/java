package com.itpro.blog.controllers;

import com.itpro.blog.models.entity.BlogPost;
import com.itpro.blog.repository.BlogPostRepository;
import com.itpro.blog.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/blog_post")
public class BlogController {

    private BlogPostRepository repository;

    public BlogController(BlogPostRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path        = "/",
                produces    = "application/json")
    public List<BlogPost> getAllBlogPost(@RequestParam( value = "limit", required = false) Integer limit) {
        return repository.getAll(limit);
    }

    @GetMapping(path        = "/{id}",
            produces    = "application/json")
    public ResponseEntity<Object> getBlogPost(@PathVariable int id) {

        if(repository.get(id) != null) {
            return Response.success(repository.get(id));
        }

        return Response.error("NO_DATA_FOUND");
    }

    @PostMapping(path = "/")
    public ResponseEntity<Object> insertNewBlogPost(@RequestBody BlogPost blogPostEntity) {

        this.repository.add(blogPostEntity);
        return Response.success(blogPostEntity, "New blog post create");
    }
}
