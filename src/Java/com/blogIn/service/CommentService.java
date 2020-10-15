package com.blogIn.service;
import com.blogIn.dao.Comment;


public interface CommentService {
	
	Comment getCommentById(Long id);
	void removeComment(Long id);
}
