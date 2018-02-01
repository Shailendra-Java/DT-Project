package com.backend.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.backend.dao.UserDao;
import com.backend.model.User;

@Repository
@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}
	public void insertUser(User user) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(user);
			session.getTransaction().commit();
		}catch(Exception exception) {
			session.getTransaction().rollback();
		}
	}
	

}
