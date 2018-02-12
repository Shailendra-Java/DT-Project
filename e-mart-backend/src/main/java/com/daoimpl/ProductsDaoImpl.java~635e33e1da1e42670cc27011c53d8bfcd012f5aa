package com.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductsDao;
import com.model.Category;
import com.model.Products;
import com.model.Supplier;

@Repository
@Service("productDaoImpl")
public class ProductsDaoImpl implements ProductsDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public ProductsDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public void insertProduct(Products products) {
		
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(products);
			session.getTransaction().commit();
		}catch(Exception exception) {
			
		}
	}

	@Override
	public List<Products> retrieve() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Products> list = session.createQuery("from Products").list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public boolean deleteProduct(int pid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Products product = (Products)session.get(Products.class, pid);
		try {
			session.delete(product);
			session.getTransaction().commit();
			return true;
		}catch(HibernateException hibernateException){
			return false;
		}
	}
	
	@Override
	public List<Products> getProductByCategoryId(int cid) {
		
		Session session = sessionFactory.openSession();
		List<Products> product = null;
		try{
			session.beginTransaction();
			product = session.createQuery("from Product where cid =" +cid).list();
			session.getTransaction().commit();
		}
		catch (Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return product;
	}

	@Override
	public Products findByProductId(int pid) {
		Session session = sessionFactory.openSession();
		Products product = null;
		try{
			session.beginTransaction();
			product = session.get(Products.class, pid);
			session.getTransaction().commit();
		}
		catch(HibernateException hibernateException){
			hibernateException.printStackTrace();
			session.getTransaction().rollback();
		}
		return product;
	}

	@Override
	public void update(Products product) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(product);
		session.getTransaction().commit();
	}
	
	
}
