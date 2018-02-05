package com.backend.dao;

import java.util.List;

import com.backend.model.Products;

public interface ProductsDao {

	void insertProduct(Products products);
	List<Products> retrieve();
	boolean deleteProduct(int pid);
	Products findByProductId(int pid);
	List<Products> getProductByCategoryId(int cid);
	void update(Products product);
}
