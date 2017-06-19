package com.yashu.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "app_product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductSequence")
	@SequenceGenerator(name = "ProductSequence", sequenceName = "ProductSequence")
	@Column(name = "prod_Id")
	private int productId;

	@Column(name = "prod_Name",nullable=false)
	private String productName;
	
	@Column(name = "prod_Price",nullable=false)
	private int productPrice;
	
	@Column(name = "prod_Supplier",nullable=false)
	private String productsupplier;

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

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductsupplier() {
		return productsupplier;
	}

	public void setProductsupplier(String productsupplier) {
		this.productsupplier = productsupplier;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", Productsupplier=" + productsupplier + "]";
	}

}
