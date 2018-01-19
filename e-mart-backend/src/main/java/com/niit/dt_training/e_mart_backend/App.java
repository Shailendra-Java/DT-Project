package com.niit.dt_training.e_mart_backend;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dt.dao.UserDao;
import com.dt.daoimpl.UserDaoImpl;
import com.dt.model.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
		cfg.configure("com/dt/config/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
        System.out.println( "User Information" );
        UserDao us = new UserDaoImpl();
        List<User> user = us.getUsers();
        for(User uDetail: user)
        {
        	System.out.println( "Name : "+uDetail.getName() );
        	System.out.println( "Password : "+uDetail.getPassword() );
        	System.out.println( "Email : "+uDetail.getEmail() );
        	System.out.println( "Role : "+uDetail.getRole() );
        	System.out.println( "Address : "+uDetail.getAddress() );
        	System.out.println( "Phone : "+uDetail.getPhone() );
        }
    }
}
