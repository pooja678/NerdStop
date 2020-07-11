package com.ecom.model;

import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
public class Cart implements Serializable {


	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int cartID;
	
	private double grandTotal;
	

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	@OneToMany(mappedBy="cart", fetch=FetchType.EAGER)
    private List<CartItem> cartItems;

    public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	/*
	(cascade=CascadeType.ALL)*/

	@OneToOne
    @JoinColumn(name="userId")
    @JsonIgnore
    private User user;



    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID=cartID;
    }

   
 

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
