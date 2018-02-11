package com.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.SupplierDao;
import com.model.Category;
import com.model.Supplier;

@Repository
@Service
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public SupplierDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public boolean insertSupplier(Supplier supplier) {
		
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(supplier);
			session.getTransaction().commit();
			return true;
		}catch(Exception exception) {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean updateSupplier(Supplier supplier) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(supplier);
			session.getTransaction().commit();
			return true;
		}catch(Exception exception) {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteSupplier(Supplier supplier) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(supplier);
			session.getTransaction().commit();
			return true;
		}catch(Exception exception) {
			return false;
		}
	}

	@Override
	public Supplier findBySupplierId(String sid) {
		
		Session session = sessionFactory.openSession();
		Supplier supplier = null;
		try{
			session.beginTransaction();
			supplier=session.get(Supplier.class, sid);
			session.getTransaction().commit();
		}
		catch(HibernateException hibernateException){
			System.out.println(hibernateException.getMessage());
			session.getTransaction().rollback();
		}
		return supplier;
	}

	@Override
	public List<Supplier> retrieve() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Supplier> list = session.createQuery("from Supplier").list();
		session.getTransaction().commit();
		return list;
	}
	
}
