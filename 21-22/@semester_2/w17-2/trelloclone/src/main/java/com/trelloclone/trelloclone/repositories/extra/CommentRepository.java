package com.trelloclone.trelloclone.repositories.extra;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trelloclone.trelloclone.models.extra.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
