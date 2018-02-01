package com.backend.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.dao.SupplierDao;
import com.backend.model.Supplier;

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

}
