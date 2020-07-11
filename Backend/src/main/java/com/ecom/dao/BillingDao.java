package com.ecom.dao;


import java.util.List;

import com.ecom.model.Billing;


public interface BillingDao {

	public boolean add(Billing billing);
	public boolean delete(int billing_Id);
	public boolean update(Billing billing);
	public Billing getBillingById(int billing_Id);
	public List<Billing> getAll();
	
}
