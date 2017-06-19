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

import com.yashu.Model.Product;
import com.yashu.Service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	// Adding a product

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ResponseEntity<String> addProduct(@RequestBody Product p) {
		try {
			productService.addProduct(p);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>(HttpStatus.CREATED);

	}

	// Fetching all the products

	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listAllProducts() {
		List<Product> list = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);

	}

	@RequestMapping(value = "/getProduct/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Product p;
		try {
			p = productService.getProductById(id);
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(p, HttpStatus.OK);

	}
	// Removing a product

	@RequestMapping(value = "/removeProduct/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") int productId) {
		try {
			productService.deleteProduct(productId);
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(HttpStatus.OK);

	}

	// Updating a product

	@RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product p) {
		Product p1;
		try {
			p1 = productService.updateProduct(id, p);

		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(p1, HttpStatus.OK);

	}
}