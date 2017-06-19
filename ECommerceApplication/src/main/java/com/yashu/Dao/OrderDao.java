package com.yashu.Dao;

import java.util.List;


//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yashu.Model.Orders;
import com.yashu.Model.Product;

@Repository
public interface OrderDao extends CrudRepository<Orders, Integer>{

	//void save(List<Product> p);
	
}
