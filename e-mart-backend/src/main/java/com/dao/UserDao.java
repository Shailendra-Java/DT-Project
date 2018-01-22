package com.dao;

import java.util.List;

import com.model.User;

public interface UserDao {

		public void insertUser(User user);
		public List<User> getUsers();
}
