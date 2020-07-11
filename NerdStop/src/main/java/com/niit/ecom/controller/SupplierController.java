package com.niit.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecom.dao.SupplierDao;
import com.ecom.model.Supplier;

@Controller
public class SupplierController {

	@Autowired
	SupplierDao supplier_Dao;
	
	
	
	@RequestMapping(value="/addSupplier",method=RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier)
	{
		if(supplier.getSupplierId()==0)
		{
			if(supplier_Dao.addSupplier(supplier))
			return "redirect:/adminsupplier?s=su";
			else
				return null;
		}
		
		else
		{
			supplier_Dao.updateSupplier(supplier);
			return "redirect:/adminsupplier?msg=successupdate";
		}
		}
	
	@RequestMapping(value="/deleteSupplier/{supplierId}",method=RequestMethod.GET)
	public String deleteSupplier(@PathVariable("supplierId")int supplierId)
	{
		
		if(supplier_Dao.deleteSupplier(supplierId))
			return "redirect:/adminallsupplier?msg=deletesuccess";
		else 
			return "redirect:/adminallsupplier?msg=deleteer";
		}
	
	@RequestMapping(value="/updateSupplier/{supplierId}",method=RequestMethod.GET)
	public String updateSupplier(@PathVariable("supplierId")int supplierId,Model model)
	{
	
		model.addAttribute("supplier",supplier_Dao.getSupplierById(supplierId));
		model.addAttribute("supplierList",supplier_Dao.getAllSupplier());
		return "adminAddSupplier";
	}

}
