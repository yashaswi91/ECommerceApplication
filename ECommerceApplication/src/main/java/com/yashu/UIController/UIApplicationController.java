package com.yashu.UIController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yashu.Model.Cart;
import com.yashu.Model.Orders;
import com.yashu.Model.Product;
import com.yashu.Model.User;
import com.yashu.Service.CartService;
import com.yashu.Service.ProductService;
import com.yashu.Service.UserService;

@Controller
public class UIApplicationController {

	@Autowired
	private ProductService p;
	
	@Autowired
	private UserService u;
	
	@Autowired
	private CartService c;

	private String message = "Welcome to eCommerce Application Portal";
	
	@RequestMapping("/")
	public String login() {
		//model.put("message",message);
		return "login1";
	}
	
	@RequestMapping("/login")
	public String login1(Map<String, Object> model) {

		model.put("message",message);
		return "login1";
	}
	
	@RequestMapping("/register")
	public String Register(Map<String, Object> model) {

		model.put("message",message);
		return "register";
	}
	
	@RequestMapping("/home")
	public String home(Model model) {

		List<Product> list = p.getAllProducts();
		model.addAttribute("list", list);
		return "home";
	}
	
	@RequestMapping("/viewProduct/{productID}")
	public String viewProduct(Model model,@PathVariable("productID") int productID) {

		Product prod = p.getProductById(productID);
		model.addAttribute("prod",prod);
		return "product";
	}

	@RequestMapping("/viewOrders/{username}")
	public String viewOrders(Model model,@PathVariable String username) {

		User user = u.findUserByName(username);
		int userId = user.getUserId();
		List<Orders> list1 = u.getOrdersById(userId);
		model.addAttribute("list1",list1);
		return "vieworders";
	}

	@RequestMapping("/viewCart/{username}")
	public String viewCart(Model model,@PathVariable("username") String username) {
		User user = u.findUserByName(username);
		int userId = user.getUserId();
		List<Cart> list2 = c.getCartByUser(userId);
		model.addAttribute("list2",list2);
		return "viewcart";
	}

	@RequestMapping("/updateUser/{username}")
	public String updateUser(Model model,@PathVariable("username") String username) {

		User user = u.findUserByName(username);
		model.addAttribute("user",user);
		return "updateUser";
	}
	
	@RequestMapping("/updateuseraddress/{username}")
	public String updateUserAddress(Model model,@PathVariable("username") String username) {

		User user = u.findUserByName(username);
		model.addAttribute("user",user);
		return "updateAddress";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		   return "login1";
	}
	
}