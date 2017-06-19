package com.yashu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yashu.Model.Orders;
import com.yashu.Model.User;
import com.yashu.Service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	// Find All Users

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.getAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	// Retrieving A Single User

	@RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") int userId) {
		User user = userService.findUserById(userId);
		if (user == null) {
			System.out.println("User with id " + userId + "not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
	
	//Retrieving a user by name
	
	@RequestMapping(value = "/getusername/{username}", method=RequestMethod.GET)
	public ResponseEntity<User> getUserByName(@PathVariable("username") String userName){
		User user = userService.findUserByName(userName);
		if(user==null){
			System.out.println("user with name " +userName+ "not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

	// Adding A User

	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user) {
		try {
			userService.addUser(user);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);

	}

	// Delete a user

	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") int userId) {
		try {
			userService.deleteUserById(userId);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(HttpStatus.OK);
	}

	// Updating a user

	@RequestMapping(value = "/updateUser/{username}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User user) {
		User user1;
		try {
			User user2= userService.findUserByName(username);
			int userId = user2.getUserId();
				user1 = userService.updateUser(userId, user);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user1, HttpStatus.OK);
	}

	// Updating user address

	@RequestMapping(value = "/updateuseraddress/{username}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateAddress(@PathVariable String username, @RequestBody User user) {
		try {
			User user2= userService.findUserByName(username);
			int userId = user2.getUserId();
			userService.updateAddress(userId, user);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(HttpStatus.OK);
	}

	// Finding order of a user

	@RequestMapping(value = "/userorder/{username}", method = RequestMethod.GET)
	public ResponseEntity<List<Orders>> userOrder(@PathVariable("id") String username) {

		User user= userService.findUserByName(username);
		if (user == null) {
			System.out.println("The user doesn't exist");
			return new ResponseEntity<List<Orders>>(HttpStatus.NOT_FOUND);
		}
		int userId = user.getUserId();
		List<Orders> list= userService.getOrdersById(userId);
		
		return new ResponseEntity<List<Orders>>(list,HttpStatus.OK);
	}
}