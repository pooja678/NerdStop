package com.ecom.dao;

import java.util.List;

import com.ecom.model.Category;



public interface CategoryDao {

	public boolean addCateogory(Category category);
	public boolean deleteCateogory(int categoryId);
	public boolean updateCateogory(Category category);
	public Category getCategoryById(int categoryId);
	public List<Category> getAllCategory();

}
