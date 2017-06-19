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

import com.yashu.Model.Cart;
import com.yashu.Model.User;
import com.yashu.Service.CartService;
import com.yashu.Service.UserService;

@RestController
public class CartController {

	@Autowired
	CartService cartService;
	
	@Autowired
	UserService userService;

	// Updating a cart
	@RequestMapping(value = "/updatecart/{id}", method = RequestMethod.PUT)
	public ResponseEntity<List<Cart>> updateCart(@PathVariable int id, @RequestBody Cart cart) {
		
		try {
			cartService.updateCart(id, cart);

		} catch (Exception e) {
			return new ResponseEntity<List<Cart>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Cart>>(HttpStatus.OK);

	}

	// Deleting all the carts
	@RequestMapping(value = "/deletecarts/{username}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable("username") String username) {
		try {
			User user= userService.findUserByName(username);
			int userId = user.getUserId();
			cartService.deleteCarts(userId);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	// Deleting a cartLine
	@RequestMapping(value = "/deleteCartLine/{username}/{cartid}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCartLine(@PathVariable("cartid") int cartId, @PathVariable("username") String username) {
		try {
			User user= userService.findUserByName(username);
			int userId = user.getUserId();
			cartService.deleteCartLine(userId, cartId);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	// Adding a cart

	@RequestMapping(value = "/addCart/{username}", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@PathVariable String username, @RequestBody Cart cart) {
		try {
			User user= userService.findUserByName(username);
			int userId = user.getUserId();
			cartService.addCart(userId, cart);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);

	}

	// Get cart by user

	@RequestMapping(value = "/getcart/{username}", method = RequestMethod.GET)
	public ResponseEntity<List<Cart>> getCart(@PathVariable("username") String username) {
		User user= userService.findUserByName(username);
		int userId = user.getUserId();
		List<Cart> cart = cartService.getCartByUser(userId);
		if (cart == null) {
			System.out.println("cart with userid " + userId + "not found");
			return new ResponseEntity<List<Cart>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Cart>>(cart, HttpStatus.OK);

	}
	
	

}
