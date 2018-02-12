package com.niit.dt_training.e_mart_backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.SupplierDao;
import com.model.Supplier;

public class SupplierTestCase {

	private static AnnotationConfigApplicationContext context;
	private static SupplierDao supplierDao;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.*");
		context.refresh();
		
		supplierDao = (SupplierDao) context.getBean("supplierDao");
	}
	/*
	@Test
	public void insertSupp() {
		
		Supplier supplier = new Supplier();
		supplier.setsId("S111");
		supplier.setSupplierName("Jack");
		supplierDao.insertSupplier(supplier);
		assertEquals("Failed to insert supplier!", true, supplierDao.insertSupplier(supplier));
	}
	@Test
	public void updateSupp() {
		
		Supplier supplier = new Supplier();
		supplier.setsId("S101");
		supplier.setSupplierName("Tom Kerry");
		supplierDao.updateSupplier(supplier);
		assertEquals("Failed to insert supplier!", true, supplierDao.updateSupplier(supplier));
	}
	@Test
	public void deleteSupp() {
		
		Supplier supplier = new Supplier();
		supplier.setsId("S101");
		supplierDao.deleteSupplier(supplier);
		assertEquals("Failed to insert supplier!", true, supplierDao.deleteSupplier(supplier));
	}
	*/
}
