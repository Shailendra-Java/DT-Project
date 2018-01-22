package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.daoimpl.UserDaoImpl;
import com.model.User;

@Configuration
@ComponentScan("com.*")
@EnableTransactionManagement
public class HibernateConfig
{
	
	
	@Autowired
	@Bean(name="dataSource")
	public DataSource getH2Data()
	{
	DriverManagerDataSource dsource = new DriverManagerDataSource();
	dsource.setDriverClassName("org.h2.Driver");
	dsource.setUrl("jdbc:h2:tcp://localhost/~/emart");
	dsource.setUsername("sa");
	dsource.setPassword("");
	System.out.println("H2 Connected"); 
	return dsource;
}
private Properties getHiber()
{
	Properties p = new Properties();
	p.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	p.put("hibernate.hbm2ddl.auto", "update");
	p.put("hibernate.show_sql", "true");
	System.out.println("Tables created");
	return p;
}
@Autowired
@Bean(name="sessionFactory")
public SessionFactory getHiberSession(DataSource datasource)
{
	LocalSessionFactoryBuilder lsfb = new LocalSessionFactoryBuilder(datasource);
	lsfb.addProperties(getHiber());
	lsfb.addAnnotatedClass(User.class);
	
	return lsfb.buildSessionFactory();
}

@Autowired
@Bean(name="UserDaoImpl")
public UserDaoImpl saveUserData(SessionFactory sf)
{
	return new UserDaoImpl(sf);

}


@Autowired
@Bean(name="UserDaoImpl")
public UserDaoImpl getUserDAO(SessionFactory sessionFactory)
{
	return new UserDaoImpl(sessionFactory);
}

@Autowired
@Bean(name="transactionManager")
public HibernateTransactionManager getTrans(SessionFactory sf)
{
HibernateTransactionManager tm = new HibernateTransactionManager(sf);
return tm;
}
}
