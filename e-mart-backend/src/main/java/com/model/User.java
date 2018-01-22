package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Component
@Entity
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	@Id
	private String email;
	private String role;
	private String address;
	private String phone;
	private String enabled;
	
	public User() {}
	public User(String name, String password, String email, String role, String address, String phone, String enabled) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
		this.address = address;
		this.phone = phone;
		this.enabled = enabled;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
}