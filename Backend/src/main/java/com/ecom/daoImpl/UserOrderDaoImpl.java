package com.ecom.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.dao.CartDao;
import com.ecom.dao.UserOrderDao;
import com.ecom.model.Cart;
import com.ecom.model.CartItem;
import com.ecom.model.UserOrder;


@Repository
@Transactional
public class UserOrderDaoImpl implements UserOrderDao {
	
	  @Autowired
	  private SessionFactory sessionFactory;
	  
	  
	  @Autowired
       private CartDao cartdao;
	public boolean addUserOrder(UserOrder order) {
		Session session =sessionFactory.getCurrentSession();
		try
		{
			session.save(order);
			return true;
		}
		catch(HibernateException ex)
		{
			return false;
		}
		
	}

	public double getUserOrderGrandTotal(int cartId) {
		
		
		double grandTotal=0;
		
		Cart cart=cartdao.getCartById(cartId);
		if(cart!=null){
		List<CartItem> cartItems=cart.getCartItems();
		
		for(CartItem item:cartItems)
			grandTotal+=item.getTotalPrice();
			
		System.out.println("GrandTotal:- "+grandTotal);
		return grandTotal;
		}
		return grandTotal;
	}

}
