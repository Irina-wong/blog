package com.blogIn.service;
 

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.blogIn.dao.User;
import com.blogIn.dao.elastic.EsBlog;
import com.blogIn.vo.TagVO;


public interface EsBlogService {
 	
	void removeEsBlog(String id);
	
	EsBlog updateEsBlog(EsBlog esBlog);
	
	EsBlog getEsBlogByBlogId(Long blogId);
 
	Page<EsBlog> listNewestEsBlogs(String keyword, Pageable pageable);

	Page<EsBlog> listHotestEsBlogs(String keyword, Pageable pageable);
	
	Page<EsBlog> listEsBlogs(Pageable pageable);
	
	List<EsBlog> listTop5NewestEsBlogs();
	
	List<EsBlog> listTop5HotestEsBlogs();
	
	List<TagVO> listTop30Tags();

	List<User> listTop12Users();
}
