package com.ecom.daoImpl;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.dao.ProductDao;
import com.ecom.model.Product;
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{


	  @Autowired
	  private SessionFactory sessionFactory;
	public boolean addProduct(Product product) {

		Session session=sessionFactory.getCurrentSession();
		try {
		session.persist(product);
		return true;
		}
		catch(HibernateException exception)
		{
			exception.printStackTrace();
			return false;
			
		}
	}

	public boolean deleteProduct(int productId) {

		Session session=sessionFactory.getCurrentSession();
		try
		{
			session.delete(getProductById(productId));
			return true;
		}
		catch(HibernateException exception)
		{
		return false;
		}
	}

	public boolean updateProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
			session.update(product);
			return true;
		}
		catch(HibernateException exception)
		{
		return false;
		}
	}

	public Product getProductById(int productId) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
			Product product=(Product) session.get(Product.class, productId);
			
			return product;
			
		}
		
		catch(HibernateException exception)
		{
		return null;
		}
	}

	public List<Product> getAllProduct() {

		System.out.println("get all product");
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Product");
		List<Product> list=(List<Product>)query.list();
		return list;
	}



	public List<Product> getAllProductByCategoryId(int categoryId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Product where categoryId=:categoryid");
		query.setParameter("categoryid", categoryId).list();
		List<Product> list=query.list();
		return list;
	}

	/*public int productIdByCategoryId(int categoryId) {
		try
		{
			System.out.println("@@@@@@@@@@@");
			Session session=sessionFactory.getCurrentSession();
		
			Query query=session.createQuery("select productId from Product where categoryId=?");
			query.setInteger(0, categoryId);
			
			System.out.println("productId:- "+	query.uniqueResult());
			
	
			
			return  (Integer) query.uniqueResult();
			
		}
		catch(HibernateException ex)
		{
		  ex.printStackTrace();
		  
		  return 0;
		}*/
		
	}


