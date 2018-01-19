package com.niit.dt_training.e_mart_backend;

import java.util.List;

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
