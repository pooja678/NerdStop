package com.ecom.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CartItem implements Serializable
{
	 @Id
	 @GeneratedValue(strategy=GenerationType.SEQUENCE)
	 private int cartItemID;

	 @ManyToOne
	 @JoinColumn(name="cartID")
	 @JsonIgnore
	 private Cart cart;

	 @ManyToOne
	 @JoinColumn(name="productId")
	 private Product product;

	 private int quantity;
	 private double totalPrice;


	 public int getCartItemID() {
	     return cartItemID;
	 }

	 public void setCartItemID(int cartItemID) {
	     this.cartItemID=cartItemID;
	 }

	 public Cart getCart() {
	     return cart;
	 }
	 
	 public void setCart(Cart cart) {
	        this.cart=cart;
	 }

	 public Product getProduct() {
	     return product;
	 }

	 public void setProduct(Product product) {
	     this.product=product;
	 }

	 public int getQuantity() {
	        return quantity;
	 }
	 
	 public void setQuantity(int quantity) {
	     this.quantity=quantity;
	 }

	 public double getTotalPrice() {
	     return totalPrice;
	 }

	 public void setTotalPrice(double totalPrice) {
	     this.totalPrice=totalPrice;
	 }
}