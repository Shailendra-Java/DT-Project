package com.backend.dao;

import java.util.List;

import com.backend.model.Category;

public interface CategoryDao {

	void insertCategory(Category category);
	Category findByCatId(String cid);
	List<Category> retrieve();
	
}
