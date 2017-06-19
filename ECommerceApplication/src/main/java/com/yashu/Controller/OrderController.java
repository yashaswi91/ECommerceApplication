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
import com.yashu.Model.Product;
import com.yashu.Service.OrderService;
import com.yashu.Service.UserService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	UserService userService;

	// Finding an order by id

	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
	public ResponseEntity<Orders> getOrder(@PathVariable("id") int orderId) {
		Orders order = orderService.findOrderById(orderId);
		if (order == null) {
			System.out.println("Order with " + orderId + "cannot be found");
			return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Orders>(order, HttpStatus.OK);

	}

	// Getting all orders

	@RequestMapping(value = "/getallorders", method = RequestMethod.GET)
	public ResponseEntity<List<Orders>> getAllOrders() {

		List<Orders> list = orderService.getAllOrders();

		return new ResponseEntity<List<Orders>>(list, HttpStatus.OK);

	}

	// Finding status of an order

	@RequestMapping(value = "/orderstatus/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> orderStatus(@PathVariable int id) {
		String status;
		try {
			status = orderService.findOrderStatusById(id);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	// Adding an order

	@RequestMapping(value = "/addorder/{id}", method = RequestMethod.POST)
	public ResponseEntity<String> addOrder(@RequestBody Orders order, @PathVariable int id) {
		/*try {
			orderService.addOrder(order,id);
		}

		catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		}

		return new ResponseEntity<String>(HttpStatus.OK);*/
		
		
		orderService.addOrder(order, id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	//Updating an order
	
	@RequestMapping(value = "/updateorder/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateOrder(@PathVariable int id, @RequestBody Orders order) {
		try {
			orderService.updateOrders(id, order);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);

	}


}