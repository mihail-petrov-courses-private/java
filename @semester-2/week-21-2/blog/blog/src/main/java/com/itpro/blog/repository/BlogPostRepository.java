package com.itpro.blog.repository;

import com.itpro.blog.models.entity.BlogPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogPostRepository {

    public BlogPost getBlogPost() {

        BlogPost reference = new BlogPost();
        reference.setTitle("New Title");
        reference.setContent("New content");

        return reference;
    }

    public List<BlogPost> getAllBlogPost() {

        List<BlogPost> collection = new ArrayList<>();

        BlogPost reference = new BlogPost();
        reference.setTitle("New Title $1");
        reference.setContent("New content $1");
        collection.add(reference);

        BlogPost example = new BlogPost();
        example.setTitle("New Title %2");
        example.setContent("New content %2");
        collection.add(example);

        return collection;
    }
}
