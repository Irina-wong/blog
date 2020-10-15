package com.logIn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogIn.dao.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
 
}
