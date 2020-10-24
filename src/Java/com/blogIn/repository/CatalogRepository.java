package com.blogIn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogIn.dao.Catalog;
import com.blogIn.dao.User;


public interface CatalogRepository extends JpaRepository<Catalog, Long>{
	
	List<Catalog> findByUser(User user);
	List<Catalog> findByUserAndName(User user,String name);
}
