package com.blogIn.service;

import java.util.List;

import com.blogIn.dao.Catalog;
import com.blogIn.dao.User;


public interface CatalogService {
	
	Catalog saveCatalog(Catalog catalog);
	
	void removeCatalog(Long id);

	Catalog getCatalogById(Long id);
	
	List<Catalog> listCatalogs(User user);
}
