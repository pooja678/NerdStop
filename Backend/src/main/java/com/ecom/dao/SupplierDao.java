package com.ecom.dao;

import java.util.List;

import com.ecom.model.Supplier;



public interface SupplierDao {

	public boolean addSupplier(Supplier supplier);
	public boolean deleteSupplier(int supplierId);
	public boolean updateSupplier(Supplier supplier);
	public Supplier getSupplierById(int supplierId);
	public List<Supplier> getAllSupplier();


}
