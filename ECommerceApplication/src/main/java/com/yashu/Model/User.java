package com.yashu.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "app_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSequence")
	@SequenceGenerator(name = "UserSequence", sequenceName= "UserSequence")
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "user_name",nullable=false, unique=true)
	private String userName;
	
	@Column(name = "user_email")
	private String email;
	
	@Column(name = "user_password",nullable=false)
	private String password;
	
	@Embedded
	@Column(name = "user_address")
	private Address address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {@JoinColumn(name = "order_id")})
	private List<Orders> userOrders;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {@JoinColumn(name = "cart_id")})
	List<Cart> cart;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Orders> getUserOrders() {
		return userOrders;
	}

	public void setUserOrders(List<Orders> userOrders) {
		this.userOrders = userOrders;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
