package com.dt.dao;

import java.util.List;

import com.dt.model.User;

public interface UserDao {

		public void insertUser(User user);
		public List<User> getUsers();
}
