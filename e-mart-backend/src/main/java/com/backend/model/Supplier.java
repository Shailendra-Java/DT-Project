package com.backend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

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
	
	public Supplier() {
		
	}
	public Supplier(String sId, String supplierName) {
		super();
		this.sId = sId;
		this.supplierName = supplierName;
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
