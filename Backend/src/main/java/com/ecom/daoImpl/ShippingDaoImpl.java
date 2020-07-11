package com.ecom.daoImpl;




import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.dao.ShippingDao;
import com.ecom.model.Shipping;

@Repository
@Transactional
public class ShippingDaoImpl implements ShippingDao{

	
	@Autowired 
	private SessionFactory sessionFactory;

	
	public boolean add(Shipping shipping) {
	Session session=sessionFactory.getCurrentSession();
	try
	{
		System.out.println("===============================");
		session.persist(shipping);
		return true;
	}
	catch(HibernateException exception)
	{
		System.out.println(exception);
		return false;
	}
	}
	
	public boolean delete(int shippingId) {
		
		Session session=sessionFactory.getCurrentSession();
		try
		{
			System.out.println("===============================");
			session.delete(getShippingById(shippingId));
			return true;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
		return false;
	}
		}


	public boolean update(Shipping shipping) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
			System.out.println("===============================");
			session.update(shipping);
			return true;
		}
		catch(HibernateException exception)
		{
			System.out.println(exception);
		return false;
	}
			}

	
	public Shipping getShippingById(int shippingId) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
			System.out.println("===============================");
			Shipping shipping=(Shipping) session.get(Shipping.class, shippingId);
			return shipping;
		}
		
		

		catch(HibernateException exception)
		{
			System.out.println(exception);
		return null;
		}
	}

	
	public List<Shipping> getAll() {
	System.out.println("Get all");
	System.out.println("===============================");
	Session session=sessionFactory.getCurrentSession();
	Query query=session.createQuery("from Shipping");
	List<Shipping> list=(List<Shipping>)query.list();
		return list;
	}

}
