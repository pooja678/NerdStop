package com.ecom.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;






@Entity
@Component
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int userId;
    
	@Column(insertable = false, updatable = false)
    private int billingId;
    

    
      
   /*	@Email( message="Please provide a valid email address")
   	@NotEmpty*/
       private String userEmail;
   	
   	
    /*   @NotEmpty(message = "Please enter username")*/
        private String userName;
      /* 
       @Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3")  */
       private String userPassword;
       
       @Column(insertable = false, updatable = false)
    private int shippingId;
	
    public int getBillingId() {
		return billingId;
	}
	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}
	public int getShippingId() {
		return shippingId;
	}
	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}

	
	
    
 /*  @Size(min=10, max=10, message="Mobile number must contain ten digits")*/
   /* @Max(value = 10)
    @Min(value=10)*/
    private long userMobile;
	

      boolean active=true;
	
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
	public Shipping getShipping() {
		return shipping;
	}
	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

  
	public long getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(long userMobile) {
		this.userMobile = userMobile;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="billingId")
    private Billing billing;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shippingId")
    private Shipping shipping;
	
	
/*
	cascade=CascadeType.ALL,*/
	
	@OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
    Cart cart;

	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	

}
