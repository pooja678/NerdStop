package com.ecom.dao;

import java.io.IOException;
import java.util.List;

import com.ecom.model.Cart;
import com.ecom.model.Product;

public interface CartDao {
	
	public Cart getCartById(int cartId);
	
	public Cart validate(int cartId) throws IOException;
	
	public boolean update(Cart cart);
	
	public Cart getCartByUserId(int userId);
	
	public int getCartIdByUserId(int userId);

	



}
