package com.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CategoryDao;
import com.model.Category;
import com.model.Supplier;

@Repository
@Service("categoryDaoImpl")
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

	@Override
	public Category findByCatId(String cid) {
		
		Session session = sessionFactory.openSession();
		Category category = null;
		try{
			session.beginTransaction();
			category=session.get(Category.class, cid);
			session.getTransaction().commit();
		}
		catch(HibernateException hibernateException){
			System.out.println(hibernateException.getMessage());
			session.getTransaction().rollback();
		}
		return category;
	}

	@Override
	public List<Category> retrieve() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Category> list = session.createQuery("from Category").list();
		session.getTransaction().commit();
		return list;
	}
	
}
