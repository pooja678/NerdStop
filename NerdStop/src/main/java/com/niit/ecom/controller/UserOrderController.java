package com.niit.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecom.dao.CartDao;
import com.ecom.dao.UserOrderDao;
import com.ecom.model.Cart;
import com.ecom.model.User;
import com.ecom.model.UserOrder;

@Controller
public class UserOrderController {
	
	@Autowired
	private CartDao cartdao;
	
	@Autowired
	private UserOrderDao userOrderdao;
	
	@RequestMapping(value="/order/{cartId}", method=RequestMethod.GET)
	public String createOrder(@PathVariable("cartId") int cartId)
	{
		UserOrder order=new UserOrder();
		
		Cart cart=cartdao.getCartById(cartId);
		
		order.setCart(cart);
		
		User user=cart.getUser();
		order.setUser(user);
		
		order.setBilling(user.getBilling());
		order.setShipping(user.getShipping());
		
		userOrderdao.addUserOrder(order);
		
		
		
		
		return "redirect:/checkout?order=su";
	}

}
