package com.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.Model.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
