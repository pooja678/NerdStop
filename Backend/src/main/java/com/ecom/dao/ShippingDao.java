package com.ecom.dao;


import java.util.List;

import com.ecom.model.Shipping;


public interface ShippingDao {

	public boolean add(Shipping shipping);
	public boolean delete(int shippingId);
	public boolean update(Shipping shipping);
	public Shipping getShippingById(int shippingId);
	public List<Shipping> getAll();
	
	
}