package com.itpro.blog.repository;

import com.itpro.blog.models.entity.BlogPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogPostRepository {

    private ArrayList<BlogPost> collectionReference;

    public BlogPostRepository() {

        collectionReference = new ArrayList<>();
        this.collectionReference.add(new BlogPost("New Title $1", "New content $1"));
        this.collectionReference.add(new BlogPost("New Title %2", "New content %2"));
        this.collectionReference.add(new BlogPost("New Title %3", "New content %3"));
        this.collectionReference.add(new BlogPost("New Title %4", "New content %4"));
        this.collectionReference.add(new BlogPost("New Title %5", "New content %5"));
        this.collectionReference.add(new BlogPost("New Title %6", "New content %6"));
    }

    public BlogPost get(int id) {

        this.collectionReference.stream()
                .filter( x -> x.getId() == id )
                .findFirst().get();

//        for(int i = 0; i < this.collectionReference.size(); i++) {
//            if(this.collectionReference.get(i).getId() == id) {
//                return this.collectionReference.get(i);
//            }
//        }

        return null;
    }

    public List<BlogPost> getAll() {
        return this.collectionReference;
    }

    public List<BlogPost> getAll(Integer limit) {

        if(limit == null) {
            return this.collectionReference;
        }

        ArrayList<BlogPost> collection = new ArrayList<>();
        for(int i = 0; i < this.collectionReference.size(); i++ ) {

            collection.add(this.collectionReference.get(i));
            if((i + 1) == limit) return collection;
        }

        return this.collectionReference;
    }

    public void add(BlogPost blogPostEntity) {
        this.collectionReference.add(blogPostEntity);
    }
}
