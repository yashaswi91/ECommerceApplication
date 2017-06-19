package com.yashu.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "app_cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CartSequence")
	@SequenceGenerator(name = "CartSequence", sequenceName = "CartSequence")
	@Column(name = "cart_id")
	private int cartId;

	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;

	@Column(name="quantity",nullable=false)
	private int quantity;

	@Column(name="price_per_line",nullable=false)
	private int price_per_line;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice_per_line() {
		return price_per_line;
	}

	public void setPrice_per_line(int price_per_line) {
		this.price_per_line = price_per_line;
	}

}
