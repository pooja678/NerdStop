package com.ecom.daoImpl;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.dao.CartItemDao;
import com.ecom.model.Cart;
import com.ecom.model.CartItem;


@Repository
@Transactional
public class CartItemDaoImpl  implements CartItemDao{

	
	  @Autowired
	  private SessionFactory sessionFactory;
	  
	public boolean addCartItem(CartItem cartItem) {
	Session session =sessionFactory.getCurrentSession();
	try
	{
		session.save(cartItem);
		
		return true;
	}
	catch(HibernateException ex)
	{
		return false;
	}
		
	}

	
	
	public int removeCartItem(int cartItemID) {
		
		
		Session session=sessionFactory.getCurrentSession();
		try
		{
			System.out.println("car item id is = "+ cartItemID);
			Query query=session.createQuery("delete from CartItem where cartItemID=:cartitemid");
			query.setParameter("cartitemid", cartItemID);
			
           System.out.println("Item Deleted");
           
           
			return query.executeUpdate();
		}
		
		catch(HibernateException ex)
		{
			
			ex.printStackTrace();
			return 0;			
		}

	}
	public boolean removeAllCartItem(Cart cart) {
       List<CartItem> cartItems=cart.getCartItems();
       for(CartItem item:cartItems)
    	   clearCart(item);
		return false;
	}

	public List<CartItem> getCartItemByProductId(int productId) {
	
		
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from CartItem where productId=:productid");
		query.setParameter("productid", productId);
		List<CartItem> list=query.list();
		
		
		return list;
	}

	public List<CartItem> getCartItemByCartId(int cartID) {
		try
		{
		
			System.out.println("getCartItemBy---> cartId= "+cartID);
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery(" from CartItem where cartID=:cartid");
			query.setParameter("cartid", cartID);
		
			 List<CartItem>list= query.list();
			 return list;


		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			  return null ;
			
		}
	}	
		
		
		public CartItem CartItemByCartId(int cartID) {
			try
			{
			
				System.out.println("getCartItemBy---> cartId= "+cartID);
				Session session=sessionFactory.getCurrentSession();
				Query query=session.createQuery(" from CartItem where cartID=:cartid");
				query.setParameter("cartid", cartID);
			
				
				 return (CartItem) query.uniqueResult();


			}
			catch(HibernateException ex)
			{
				ex.printStackTrace();
				  return null ;
				
			}
		
	}

		public boolean update(CartItem item) {
			Session session=sessionFactory.getCurrentSession();
			try
			{
				session.update(item);
				return true;
			}
			catch(HibernateException exception)
			{
			return false;
			}
		
		}



		public CartItem clearCart(CartItem cart) {
			Session session=sessionFactory.getCurrentSession();
			session.delete(cart);
			session.flush();
			return null;
		}
		
		
	

	
		}
		
		



