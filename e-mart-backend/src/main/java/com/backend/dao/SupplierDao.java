package com.backend.dao;

import com.backend.model.Supplier;

public interface SupplierDao {

	boolean insertSupplier(Supplier supplier);
	boolean updateSupplier(Supplier supplier);
	boolean deleteSupplier(Supplier supplier);
}
