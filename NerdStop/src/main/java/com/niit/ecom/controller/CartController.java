package com.niit.ecom.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecom.dao.CartDao;
import com.ecom.dao.CartItemDao;
import com.ecom.dao.ProductDao;
import com.ecom.dao.UserDao;
import com.ecom.dao.UserOrderDao;
import com.ecom.model.Cart;
import com.ecom.model.CartItem;
import com.ecom.model.Product;
import com.ecom.model.User;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	
	@Autowired
	UserDao userdao;
	
	@Autowired
	ProductDao productdao;
	
	@Autowired
	CartDao cartdao;
	
	
	@Autowired
	CartItemDao cartItemdao;
	
	
	@Autowired
	UserOrderDao userOrderdao;
	
	@RequestMapping(value="/add/{productId}" ,method=RequestMethod.GET)
	public String addItem(@PathVariable("productId") int productId,Principal p)
	{
		
		
	
		System.out.println("In Controller method addItem");
		
		System.out.println("ProductId="+productId);
		
		String userEmail=null;
		userEmail=p.getName();
		
		System.out.println("UserEmail= "+userEmail);
		
		User user=userdao.getUserByEmail(userEmail);
		
		System.out.println("user= "+user);
		
		
		
		
		
	
		Cart cart=cartdao.getCartByUserId(user.getUserId());
		System.out.println("userId= "+user.getUserId());
		
		
		if(cart==null){
			cart=new Cart();
		
			System.out.println("Cart= "+cart);
			
		}
		

		cart.setUser(user);
		
		System.out.println("===============");
		
		
		
		Product product=productdao.getProductById(productId);
		
		System.out.println("ProductName= "+product.getProductName());
		
		
		
		CartItem item= cartItemdao.CartItemByCartId(cart.getCartID());
		
		if(item==null)
		{
	    item=new CartItem();
		item.setProduct(product);
		item.setQuantity(1);
		item.setTotalPrice(product.getProductPrice()*item.getQuantity());
		}
		else
		{
			item.setQuantity(item.getQuantity()+1);
			item.setTotalPrice(item.getTotalPrice()+product.getProductPrice());
		}
		System.out.println("price: -"+item.getTotalPrice());
	item.setCart(cart);
		/*ArrayList<CartItem> list= new ArrayList<CartItem>();
		list.add(item);
		cart.setCartItems(list);*/
		cartItemdao.addCartItem(item);
		
		cartdao.update(cart);
		
 System.out.println("====================================");
		

		
		
		
	return "redirect:/view-product/"+productId+"?cartItem=su";
	}
	
	
	
	@RequestMapping(value="/remove/{cartItemID}", method=RequestMethod.GET)
	public String removeItem(@PathVariable("cartItemID") int cartItemID,Cart cart)
	{
		int item = cartItemdao.removeCartItem(cartItemID);
       
		return "redirect:/cart?remove=su";
	}
	
	@RequestMapping(value="/clearCart/{cartId}", method=RequestMethod.GET)
	public String clearCart(@PathVariable("cartId") int cartId)
	{
		Cart cart=cartdao.getCartById(cartId);
		cartItemdao.removeAllCartItem(cart);
		return "redirect:/cart?clear?su";
	}

}
