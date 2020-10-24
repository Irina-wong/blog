package com.blogIn.repository.elastic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.blogIn.dao.elastic.EsBlog;

public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {
 
	Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContainingOrTagsContaining(String title,String Summary,String content,String tags,Pageable pageable);
	
	EsBlog findByBlogId(Long blogId);
}
