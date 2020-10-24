package com.blogIn.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.blogIn.dao.Blog;
import com.blogIn.dao.Catalog;
import com.blogIn.dao.User;


public interface BlogRepository extends JpaRepository<Blog, Long>{
	
	@Deprecated
	Page<Blog> findByUserAndTitleLikeOrderByCreateTimeDesc(User user, String title, Pageable pageable);
	
	// Find usera list
	Page<Blog> findByUserAndTitleLike(User user, String title, Pageable pageable);
	
	Page<Blog> findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc(String title,User user,String tags,User user2,Pageable pageable);
	
	Page<Blog> findByCatalog(Catalog catalog, Pageable pageable);
}
