package com.dt.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.dt.dao.UserDao;
import com.dt.model.User;

public class UserDaoImpl implements UserDao {

	List<User> users;
	public UserDaoImpl() {

		users = new ArrayList<User>();
		User user = new User("John","123","john@abc.com","user","London","978767676");	
		users.add(user);
	}
	public void insertUser(User user) {
		
	}
	public List<User> getUsers() {	
		return users;
	}
	

}
