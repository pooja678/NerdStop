package com.ecom.daoImpl;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.dao.CategoryDao;
import com.ecom.model.Category;


@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao{

	 @Autowired
		private SessionFactory sessionFactory;
	public boolean addCateogory(Category category) {
		Session session=sessionFactory.getCurrentSession();
		try {
		session.persist(category);
		return true;
		}
		catch(HibernateException exception)
		{
			exception.printStackTrace();
			return false;
			
		}
	}

	public boolean deleteCateogory(int categoryId) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
			session.delete(getCategoryById(categoryId));
			return true;
		}
		catch(HibernateException exception)
		{
		return false;
		}
	}

	public boolean updateCateogory(Category category) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
			session.update(category);
			return true;
		}
		catch(HibernateException exception)
		{
		return false;
		}
	}

	

	public List<Category> getAllCategory() {
		System.out.println("get all category");
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Category");
		List<Category> list=(List<Category>)query.list();
		return list;
	}

	public Category getCategoryById(int categoryId) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
			Category category=(Category) session.get(Category.class, categoryId);
			
			return category;
			
		}
		
		catch(HibernateException exception)
		{
		return null;
		}
		
	}

}
