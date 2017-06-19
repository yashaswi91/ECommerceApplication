package com.yashu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yashu.Dao.UserDao;
import com.yashu.Model.Orders;
import com.yashu.Model.User;

@Repository
@Transactional
public class UserService {

	@Autowired
	UserDao userDao;

	public User findUserById(int userId) {
		return userDao.findOne(userId);
	}
	
	public User findUserByName(String userName){
		return userDao.findOneByuserName(userName);
	}

	public List<User> getAllUsers() {
		return (List<User>) userDao.findAll();
	}

	public void deleteUserById(int userId) {
		userDao.delete(userId);
	}

	public User addUser(User user){
		return userDao.save(user);
	}
	
	public User updateUser(int userId, User user){
		User user1;
		if(userDao.exists(userId)){
			user1 = userDao.findOne(userId);
			user1.setUserName(user.getUserName());
			user1.setPassword(user.getPassword());
			user1.setEmail(user.getEmail());
			userDao.save(user1);
		}
		
		else{
			System.out.println("User doesn't exist");
			return null;
		}
		return user1;
	}
	
	public void updateAddress(int userId, User user){
		User user1;
		if(userDao.exists(userId)){
			user1 = userDao.findOne(userId);
			user1.setAddress(user.getAddress());
			userDao.save(user1);
		}
	}
	
	public List<Orders> getOrdersById(int userId){
		List<Orders> order = userDao.findOne(userId).getUserOrders();
		return order;
	}
	
	public boolean isUserExist(int userId){
		return userDao.exists(userId);
		
	}
}