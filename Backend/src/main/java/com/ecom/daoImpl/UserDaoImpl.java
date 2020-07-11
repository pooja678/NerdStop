 package com.ecom.daoImpl;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.dao.UserDao;
import com.ecom.model.Authorization;
import com.ecom.model.Billing;
import com.ecom.model.Shipping;
import com.ecom.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	 private SessionFactory sessionFactory;

	public boolean addUser(User user) {
		
	    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		Session session=sessionFactory.getCurrentSession();
		
		
		try {
	
			Authorization auth=new Authorization();
		
			user.setUserPassword(encoder.encode(user.getUserPassword()));
			user.getBilling().setUser(user);
		  user.getShipping().setUser(user);
		  
		    session.persist(user);
			session.persist(user.getBilling());
			session.persist(user.getShipping());
			
        auth.setRoleName(user.getUserEmail());

			session.persist(auth);
		
		
		
		return true;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
			exception.printStackTrace();
			return false;
			
		}
		
	}


	public boolean deleteUser(int userId) {
		

		Session session=sessionFactory.getCurrentSession();
		try
		{
			
			session.delete(getUserById(userId));
			return true;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
		return false;
		}
	}

	public boolean updateUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
			
			session.update(user);
			return true;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
		return false;
		}
	}

	public User getUserById(int userId) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
			
			User user=(User) session.get(User.class, userId);
			
			return user;
			
		}
		
		catch(HibernateException exception)
		{
			System.out.println(exception);
		return null;
		}
	}

	public List<User> getAllUser() {
		System.out.println("get all user");
	
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User");
		List<User> list=(List<User>)query.list();
		return list;
	}


	public String getUserNameByUserId(int userId) {
	
		try
		{
			System.out.println("***************************");
			Session session=sessionFactory.getCurrentSession();
	        Query query=session.createSQLQuery("select userName from User where userId=?");
	        query.setInteger(0, userId);
	        System.out.println(query.uniqueResult());
	        return (String) query.uniqueResult();
	        
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
			return null;
		}
		
	}


	public User getUserByEmail(String userEmail) {
	try
	{
		System.out.println("@@@@@@@@@@@");
		Session session=sessionFactory.getCurrentSession();
	
		Query query=session.createQuery("from User where userEmail=?");
		query.setString(0, userEmail);
		
		return (User) query.uniqueResult();
		
	}
	catch(HibernateException ex)
	{
		return null;
	}
		
	}

	public int getUserIdByUserEmail(String userEmail) {
		try
		{
			System.out.println("@@@@@@@@@@@");
			Session session=sessionFactory.getCurrentSession();
		
			Query query=session.createQuery("select userId from User where userEmail=?");
			query.setString(0, userEmail);
			/*
			System.out.println("userId:- "+	query.uniqueResult());*/
			
	
			
			return  (Integer) query.uniqueResult();
			
		}
		catch(HibernateException ex)
		{
		  ex.printStackTrace();
		  
		  return 0;
		}
	
	}


	public String getUserEmailByUserId(int userId) {
		try
		{
			System.out.println("***************************");
			Session session=sessionFactory.getCurrentSession();
	        Query query=session.createSQLQuery("select userEmail from User where userId=?");
	        query.setInteger(0, userId);
	        System.out.println(query.uniqueResult());
	        return (String) query.uniqueResult();
	        
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
			return null;
		}
		
	}

}
