package com.yashu.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yashu.Model.Cart;

@Repository
public interface CartDao extends CrudRepository<Cart, Integer>{

	void save(int cartId);

}
