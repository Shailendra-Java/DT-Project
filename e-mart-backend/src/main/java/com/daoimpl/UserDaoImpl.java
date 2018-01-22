package com.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.dao.UserDao;
import com.model.User;

public class UserDaoImpl implements UserDao {

	List<User> users;
	public UserDaoImpl(SessionFactory sf) {

		
	}
	public void insertUser(User user) {
		
	}
	public List<User> getUsers() {	
		return users;
	}
	

}
