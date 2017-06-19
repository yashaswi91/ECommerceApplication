package com.yashu.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.yashu.Model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	User findOneByuserName(String userName);

}
