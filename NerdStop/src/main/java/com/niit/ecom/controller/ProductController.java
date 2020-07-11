package com.niit.ecom.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.dao.CategoryDao;
import com.ecom.dao.ProductDao;
import com.ecom.model.Product;

@Controller
public class ProductController {

	@Autowired
	private ProductDao product_Dao;
	
	@Autowired
	private CategoryDao  category_dao;
	
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String productPage(@ModelAttribute("product") @Valid Product product,BindingResult result, Model model,  HttpServletRequest request)
	{
		System.out.println("product="+product);
		if(result.hasErrors())
			{
				
				return "adminAddProduct";
			}
			else
			{
			if(product.getProductId()==0)
			{
		     product_Dao.addProduct(product);
			MultipartFile file=product.getProductImage();
					String filelocation=request.getSession().getServletContext().getRealPath("/resources/images/");
					System.out.println(filelocation);
					String filename=filelocation+"\\"+product.getProductId()+".jpg";
					System.out.println(filename);
				
					try
					{
						byte b[]=file.getBytes();
						FileOutputStream fos= new FileOutputStream(filename);
						fos.write(b);
						fos.close();
				}
					catch(IOException e)
					{
						System.out.println(e);
					}
					
					return "redirect:/adminproduct?p=su";
				}
		
			else
			{
				product_Dao.updateProduct(product);
				return "redirect:/adminallProduct?msg=successupdate";
				
			}
			

		
			
			}
}
	
		@RequestMapping(value="/deleteProduct/{productId}", method=RequestMethod.GET)
	public String deleteProduct(@PathVariable("productId")int productId)
	{
		if(product_Dao.deleteProduct(productId))
			return "redirect:/adminallProduct?msg=deletesuccess";
		else
			return "redirect:/adminallProduct?msg=deleteer";

	}
	
	@RequestMapping(value="/updateProduct/{productId}", method=RequestMethod.GET)
	public String updateProduct(@PathVariable("productId") int productId, Model model)
	{
       model.addAttribute("product",product_Dao.getProductById(productId));
       
       model.addAttribute("categoryList", category_dao.getAllCategory());
       model.addAttribute("productList",product_Dao.getAllProduct());
		
		return "adminAddProduct";
	}
	
	
}
