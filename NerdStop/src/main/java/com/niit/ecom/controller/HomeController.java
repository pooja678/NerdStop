package com.niit.ecom.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecom.dao.CartDao;
import com.ecom.dao.CartItemDao;
import com.ecom.dao.CategoryDao;
import com.ecom.dao.ProductDao;
import com.ecom.dao.SupplierDao;
import com.ecom.dao.UserDao;
import com.ecom.dao.UserOrderDao;
import com.ecom.model.Billing;
import com.ecom.model.Cart;
import com.ecom.model.CartItem;
import com.ecom.model.Category;
import com.ecom.model.Product;
import com.ecom.model.Shipping;
import com.ecom.model.Supplier;
import com.ecom.model.User;
import com.ecom.model.UserOrder;

@Controller
@ComponentScan("com.niit.ecom")
public class HomeController {
	
	@Autowired
	User user;
	
	@Autowired
	UserOrderDao orderdao;
	
	@Autowired(required=true)
	Cart cart;
	
	@Autowired
	Billing billing;
	
	@Autowired
	Shipping shipping;
	
	@Autowired
	UserDao user_dao;
	
	@Autowired
	CartDao cart_dao;
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDao product_dao;
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao category_dao;
	
	/*
	@Autowired
	CartItem cartItem;*/
	
	@Autowired
	CartItemDao cartItemdao;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDao supplier_dao;
	
	@RequestMapping("/")
	public String index(Model model)
	{
		model.addAttribute("categoryList", category_dao.getAllCategory());
		return "index";
	}
	
	
	@RequestMapping("/login")
	public String login()
	{
		
		return "login";
	}
	
	
	
	@RequestMapping(value="/view-product/{productId}", method=RequestMethod.GET)
	public String viewProduct(@PathVariable("productId") int productId,Model model)
	{
		model.addAttribute("categoryList", category_dao.getAllCategory());
		model.addAttribute("product", product_dao.getProductById(productId));
	   return  "viewProduct";
	}
	
	
	

	
	@RequestMapping(value="/{categoryId}", method=RequestMethod.GET)
	public String New(@PathVariable("categoryId")int categoryId,Model model)
	{
		
		model.addAttribute("categoryList", category_dao.getAllCategory());
		model.addAttribute("productList",product_dao.getAllProductByCategoryId(categoryId));
		return "categoriesPage";
	}

	@RequestMapping("/logout")
	public String logout()
	{
		
		return "logout";
	}
	

	@RequestMapping("/header")
	public String header(Model model)
	{
	
		model.addAttribute("categoryList",category_dao.getAllCategory());
		return "header_user";
	}
	

	@RequestMapping("/logg")
	public String logg()
	{
		
		return "logg";
	}
	
	
	
	
	
	
	
	@RequestMapping("/register")
	public String user(Model model)
	{
		user.setBilling(billing);
		user.setShipping(shipping);
		model.addAttribute("user",user);
		
		return "register";
	}
	
	

	@RequestMapping("/adminhome")
	public String adminHome()
	{
		
		
		return "adminHome";
	}
	
	@RequestMapping("/cart")
	public String cart(Model model,Principal p)
	{
		
		String userEmail=null;
		userEmail=p.getName();
		System.out.println("UserEmail= "+userEmail);
		User user=user_dao.getUserByEmail(userEmail);
	   int userId=user_dao.getUserIdByUserEmail(userEmail);
		System.out.println("UserId= "+userId);

		
		int cartId=cart_dao.getCartIdByUserId(userId);
		
		System.out.println("cartId=== "+cartId);
		
	model.addAttribute("total",orderdao.getUserOrderGrandTotal(cartId));
	
        Cart cart=cart_dao.getCartById(cartId);
		
		model.addAttribute("item",cartItemdao.getCartItemByCartId(cartId));
	
		System.out.println("ITEM= "+ cartItemdao.getCartItemByCartId(cartId));
		
		
		cart_dao.update(cart);
		
		

	
	
		return "cart";
	}
	
	@RequestMapping("/checkout")
	public String checkout(Model model,Principal p)
	{
		String userEmail=null;
		userEmail=p.getName();
		System.out.println("UserEmail= "+userEmail);
		User user=user_dao.getUserByEmail(userEmail);
	   int userId=user_dao.getUserIdByUserEmail(userEmail);
	   
		System.out.println("UserId= "+userId);
     int cartId=cart_dao.getCartIdByUserId(userId);
   model.addAttribute("email",user_dao.getUserEmailByUserId(userId));
   model.addAttribute("cartId",cart_dao.getCartIdByUserId(userId));
		System.out.println("cartId=== "+cartId);

		model.addAttribute("total",orderdao.getUserOrderGrandTotal(cartId));
		
		model.addAttribute("name", user_dao.getUserNameByUserId(userId));
		
		return "checkout";
	}

	
	@RequestMapping("/products")
	public String products(Model model)
	{
	
		model.addAttribute("products",product);
		model.addAttribute("productList",product_dao.getAllProduct());
		return "products";
	}
	
	@RequestMapping("/allUser")
	public String allUser(Model model)
	{
		
		model.addAttribute("userList",user_dao.getAllUser());
		return "adminAllUser";
	}
	

	
	@RequestMapping("/adminproduct")
	public String product(Model model)
	{
		model.addAttribute("categoryList",category_dao.getAllCategory());
		model.addAttribute("product", product);
		return "adminAddProduct";
	}
	
	
     @RequestMapping("/adminallProduct")
	public String allProduct(Model model)
	{
		model.addAttribute("productList",product_dao.getAllProduct());
	
		return "adminAllProduct";
	}
     
     
     

 	@RequestMapping("/admincategory")
 	public String category(Model model)
 	{
 		
 		model.addAttribute("category", category);
 		return "adminAddCategory";
 	}
 	
     
 	@RequestMapping("/adminallcategory")
	public String allCategory(Model model)
	{
		model.addAttribute("categoryList",category_dao.getAllCategory());
	
		return "adminAllCategory";
	}
 	

 	@RequestMapping("/adminsupplier")
 	public String supplier(Model model)
 	{
 		
 		model.addAttribute("supplier",supplier);
 		return "adminAddSupplier";
 	}
 	
 	@RequestMapping("/adminallsupplier")
	public String allSupplier(Model model)
	{
		model.addAttribute("supplierList",supplier_dao.getAllSupplier());
	
		return "adminAllSupplier";
	}
	
}
