package com.ecom.daoImpl;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.dao.BillingDao;
import com.ecom.model.Billing;

@Repository
@Transactional
public class BillingDaoImpl  implements BillingDao{
	
	
	
	
	@Autowired 
	private SessionFactory sessionFactory;

	
	public boolean add(Billing billing) {
	Session session=sessionFactory.getCurrentSession();
	try
	{
		System.out.println("===============================");
		session.persist(billing);
		return true;
	}
	catch(HibernateException exception)
	{
		System.out.println(exception);
		return false;
	}
	}
	
	public boolean delete(int billing_Id) {
		
		Session session=sessionFactory.getCurrentSession();
		try
		{
			System.out.println("===============================");
			session.delete(getBillingById(billing_Id));
			return true;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
		return false;
	}
		}

	
	public boolean update(Billing billing) {
		Session session=sessionFactory.getCurrentSession();
		try
		{System.out.println("===============================");
			session.update(billing);
			return true;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
		return false;
	}
			}

	
	public Billing getBillingById(int billing_Id) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
			System.out.println("===============================");
			Billing billing=(Billing) session.get(Billing.class, billing_Id);
			return billing;
		}
		
		

		catch(HibernateException exception)
		{
			System.out.println(exception);
		return null;
		}
	}

	
	public List<Billing> getAll() {
	System.out.println("Get all");
	System.out.println("===============================");
	Session session=sessionFactory.getCurrentSession();
	Query query=session.createQuery("from Billing");
	List<Billing> list=(List<Billing>)query.list();
		return list;
	}


}
