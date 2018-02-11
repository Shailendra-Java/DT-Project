package com.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Supplier implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String sId;
	@NotBlank(message = "Please enter Supplier Name!")
	private String supplierName;
	
	@OneToMany(targetEntity=Products.class, fetch = FetchType.EAGER, mappedBy="supplier")
	private Set<Products> products = new HashSet<Products>(0);
	
	public Set<Products> getProducts() {
		return products;
	}
	public void setProducts(Set<Products> products) {
		this.products = products;
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
}
