package com.dao;

import java.util.List;

import com.model.Supplier;

public interface SupplierDao {

	boolean insertSupplier(Supplier supplier);
	boolean updateSupplier(Supplier supplier);
	boolean deleteSupplier(Supplier supplier);
	Supplier findBySupplierId(String sid);
	List<Supplier> retrieve();
}
