package com.backend.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.dao.CategoryDao;
import com.backend.model.Category;

@Repository
@Service
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public CategoryDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public void insertCategory(Category category) {
		
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(category);
			session.getTransaction().commit();
		}catch(Exception exception) {
			
		}
	}

}
