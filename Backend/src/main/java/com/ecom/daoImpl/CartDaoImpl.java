package com.ecom.daoImpl;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.dao.CartDao;
import com.ecom.dao.UserOrderDao;
import com.ecom.model.Cart;


@Repository
@Transactional
public class CartDaoImpl implements CartDao {

	  @Autowired
	  private SessionFactory sessionFactory;
	  
	  @Autowired
	  UserOrderDao userOrderdao;
	  
	
	public Cart getCartById(int cartId) {
		
		Session session=sessionFactory.getCurrentSession();
		
		try
		{
			Cart cart=session.get(Cart.class, cartId);
			System.out.println("CARTID=== "+cartId);
			return cart;
		}
		catch(HibernateException ex)
		{
			return null;
		}
		
		
	}

	public Cart validate(int cartId) throws IOException {

           
            	
            	Cart cart=getCartById(cartId);
            	if(cart==null||cart.getCartItems().size()==0)
            		throw new IOException(cartId+"");
            	
        update(cart);
		return cart;
	}

	public boolean update(Cart cart) {
	
		
		int cartId=cart.getCartID();
		System.out.println("cartId---->"+cartId);
		double grandTotal=userOrderdao.getUserOrderGrandTotal(cartId);
		cart.setGrandTotal(grandTotal);
		
		Session session=sessionFactory.getCurrentSession();
		session.merge(cart);
 		
		return true;
	}

	public Cart getCartByUserId(int userId) {
	
	try
		{
		
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Cart where userId=?");
			query.setInteger(0, userId);
			System.out.println("userId= "+userId);
			return (Cart) query.uniqueResult();
			


		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			  return null ;
			
		}
		
    
	}

	public int getCartIdByUserId(int userId) {
		try
		{
		
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("select cartID from Cart where userId=?");
			query.setInteger(0,userId);
			System.out.println("userId= "+userId);
			return  (Integer) query.uniqueResult();


		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			  return 0 ;
			
		}
	}

}