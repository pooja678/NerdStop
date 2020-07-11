package com.niit.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecom.dao.CategoryDao;
import com.ecom.model.Category;

@Controller
public class CategoryController {
	@Autowired
	private  CategoryDao categoryDao;
	
	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	public String addCategory(@ModelAttribute("category")Category category)
	{
		if(category.getCategoryId()==0)
		{
			if(categoryDao.addCateogory(category))
				return "redirect:/admincategory?c=su";
			else
				return null;
		}
		else
		{
			categoryDao.updateCateogory(category);
			return "redirect:/adminallcategory?msg=successupdate";
		}
	}
	
	
	@RequestMapping(value="/deleteCategory/{CategoryId}", method=RequestMethod.GET)
	public String deleteCategory(@PathVariable("CategoryId") int categoryId)
	{

		if(categoryDao.deleteCateogory(categoryId))
			return "redirect:/adminallcategory?msg=deletesuccess";
		else
			return "redirect:/adminallProduct?msg=deleteer";
	}
	
	
	@RequestMapping(value="/updateCategory/{categoryId}", method=RequestMethod.GET)
	public String updateCategory(@PathVariable("categoryId")int categoryId, Model model)
	{
		
		model.addAttribute("category",categoryDao.getCategoryById(categoryId));
		model.addAttribute("categoryList", categoryDao.getAllCategory());
		return "adminAddCategory";
	}

}
