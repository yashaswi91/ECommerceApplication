
package com.yashu.Model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "app_order")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrderSequence")
	@SequenceGenerator(name = "OrderSequence", sequenceName = "OrderSequence")
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "order_date",nullable=false)
	private Date orderDate;
	
	@Column(name = "order_status",nullable=false)
	private String orderStatus;
	
	@Column(name = "ship_date")
	private Date shipDate;
	
	@Column(name = "order_price",nullable=false)
	private int orderPrice;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = {@JoinColumn(name = "product_id")})
	private Set<Product> listOfProducts = new HashSet<>();

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public Set<Product> getListOfProducts() {
		return listOfProducts;
	}

	public void setListOfProducts(Set<Product> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	
		
}
