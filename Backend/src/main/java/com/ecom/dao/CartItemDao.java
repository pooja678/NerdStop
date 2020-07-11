package com.ecom.dao;

import java.util.List;

import com.ecom.model.Cart;
import com.ecom.model.CartItem;

public interface CartItemDao {
	public boolean addCartItem(CartItem cartItem);
	
	public int removeCartItem(int cartItemID);
	
	public List<CartItem> getCartItemByCartId(int cartId);
	
	public CartItem CartItemByCartId(int cartId);
	
	
	public CartItem clearCart(CartItem cart);
	
	public boolean removeAllCartItem(Cart cart) ;
	public List<CartItem> getCartItemByProductId(int productId);
	

	
	public boolean update(CartItem item);

}
