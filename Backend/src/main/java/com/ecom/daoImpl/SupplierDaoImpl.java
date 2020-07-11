package com.ecom.daoImpl;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.dao.SupplierDao;
import com.ecom.model.Supplier;


@Repository
@Transactional
public class SupplierDaoImpl implements SupplierDao{

	@Autowired
	private SessionFactory sessionFactory;
	public boolean addSupplier(Supplier supplier) {
		Session session=sessionFactory.getCurrentSession();
		try {
		session.persist(supplier);
		return true;
		}
		catch(HibernateException exception)
		{
			exception.printStackTrace();
			return false;
			
		}
	}

	public boolean deleteSupplier(int supplierId) {

		Session session=sessionFactory.getCurrentSession();
		try
		{
			
			session.delete(getSupplierById(supplierId));
			return true;
		}
		catch(HibernateException exception)
		{
		return false;
		}
	}

	public boolean updateSupplier(Supplier supplier) {

		Session session=sessionFactory.getCurrentSession();
		try
		{
			session.update(supplier);
			return true;
		}
		catch(HibernateException exception)
		{
		return false;
		}
	}

	public Supplier getSupplierById(int supplierId) {

		Session session=sessionFactory.getCurrentSession();
		try
		{
			Supplier supplier=(Supplier) session.get(Supplier.class, supplierId);
			
			return supplier;
			
		}
		
		catch(HibernateException exception)
		{
		return null;
		}
	}

	public List<Supplier> getAllSupplier() {

		System.out.println("get all supplier");
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> list=(List<Supplier>)query.list();
		return list;
	}

}
