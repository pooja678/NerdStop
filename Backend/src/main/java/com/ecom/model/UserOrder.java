package com.ecom.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class UserOrder implements Serializable{

	@Id
    @GeneratedValue
    private int userOrderID;

    @OneToOne
    @JoinColumn(name="cartID")
    private Cart cart;

    @OneToOne
    @JoinColumn(name="userID")
    private User user;

    @OneToOne
    @JoinColumn(name="billingId")
    private Billing billing;

    @OneToOne
    @JoinColumn(name="shippingId")
    private Shipping shipping;

	public int getUserOrderID() {
		return userOrderID;
	}

	public void setUserOrderID(int userOrderID) {
		this.userOrderID = userOrderID;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

   
}