package com.ecom.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int productId;
	
	@NotEmpty(message="Product name can not be empty")
	private String productName;
	

	@NotEmpty(message="Product Description can not be empty")
	private String productDesc;
	

	private int quantity;
	

	@NotNull(message="Product price can not be empty")
	private int productPrice;
	

	private int categoryId;
	
    @ManyToOne()// For the Mapping 
	@JoinColumn(name="categoryId",insertable = false,updatable=false,nullable=false)// This annotation this used to tell at which column data is going
	private Category category; //Create the reference of the Category Table


	@Transient
	MultipartFile productImage;
	
	public int getProductId() {
		return productId;
	}




	public void setProductId(int productId) {
		this.productId = productId;
	}




	public String getProductName() {
		return productName;
	}




	public void setProductName(String productName) {
		this.productName = productName;
	}




	public String getProductDesc() {
		return productDesc;
	}




	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}















	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public int getProductPrice() {
		return productPrice;
	}

   public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getCategoryId() {
		return categoryId;
	}

public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
public MultipartFile getProductImage() {
		return productImage;
	}


public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

public Category getCategory() {
		return category;
	}
 public void setCategory(Category category) {
		this.category = category;
	}





	
}
