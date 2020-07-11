package com.ecom.dao;


import java.util.List;

import com.ecom.model.Product;


public interface ProductDao {

	public boolean addProduct(Product product);
	public boolean deleteProduct(int productId);
	public boolean updateProduct(Product product);
	public Product getProductById(int productId);
	public List<Product> getAllProduct();
	
	/*public int productIdByCategoryId(int categoryId);*/

	public List<Product> getAllProductByCategoryId(int categoryId);

}