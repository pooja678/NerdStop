package com.ecom.dao;

import com.ecom.model.UserOrder;

public interface UserOrderDao {
	
	public boolean addUserOrder(UserOrder order);
	
	public double getUserOrderGrandTotal(int cartId);

}
