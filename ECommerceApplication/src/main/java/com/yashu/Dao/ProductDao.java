package com.yashu.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yashu.Model.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {

//	public void addProduct(Product p);
//	public void deleteProduct(int productId);
//	public void updateProduct(Product p);
//	public void getAllProduct();
}
