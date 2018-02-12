package com.dao;

import java.util.List;

import com.model.Category;

public interface CategoryDao {

	void insertCategory(Category category);
	Category findByCatId(String cid);
	List<Category> retrieve();
	
}
