package com.yashu.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yashu.Dao.ProductDao;
import com.yashu.Model.Product;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductDao pdao;

	public Product addProduct(Product p) {
		return pdao.save(p);
	}

	public void deleteProduct(int productId) {
		pdao.delete(productId);
	}

	public Product updateProduct(int productId, Product p) {
		Product p2;
		if (pdao.exists(productId)) {
			p2 = pdao.findOne(productId);
			p2.setProductName(p.getProductName());
			p2.setProductPrice(p.getProductPrice());
			p2.setProductsupplier(p.getProductsupplier());
			pdao.save(p2);
		}

		else {
			System.out.println("Product does not exist. Update cannot be done");
			return null;
		}
		return p2;
	}

	public List<Product> getAllProducts() {
		return (List<Product>) pdao.findAll();

	}

	public Product getProductById(int productId) {
		return pdao.findOne(productId);
	}
}
