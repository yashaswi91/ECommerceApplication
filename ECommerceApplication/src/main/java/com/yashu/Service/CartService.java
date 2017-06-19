package com.yashu.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yashu.Dao.CartDao;
import com.yashu.Dao.ProductDao;
import com.yashu.Dao.UserDao;
import com.yashu.Model.Cart;
import com.yashu.Model.Product;
import com.yashu.Model.User;

@Service
@Transactional
public class CartService {

	@Autowired
	CartDao cartDao;

	@Autowired
	UserDao userDao;

	@Autowired
	ProductDao prodDao;
	
	public Cart updateCart(int cartId, Cart cart) {
		Cart cart2 = cartDao.findOne(cartId);
		cart2.setQuantity(cart.getQuantity());
		int p = cart2.getProduct().getProductPrice() * cart.getQuantity();
		cart2.setPrice_per_line(p);
		return cartDao.save(cart2);

	}

	public void deleteCarts(int userId) {
		User user = userDao.findOne(userId);
		List<Cart> list = user.getCart();
		for (Cart cart : list) {
			deleteCartLine(userId,cart.getCartId());
		}

	}

	public void deleteCartLine(int userId, int cart_id) {
		User user = userDao.findOne(userId);
		Cart cart = cartDao.findOne(cart_id);

		List<Cart> list = user.getCart();
		list.remove(cart);
		user.setCart(list);
		userDao.save(user);

		cart.setProduct(null);
		cartDao.save(cart);
		cartDao.delete(cart);
	}

	public Cart addCart(int userId, Cart cart) {
			User user = userDao.findOne(userId);
			List<Cart> list = user.getCart();

			for (Cart cart2 : list) {
				if (cart2.getProduct().getProductId() == cart.getProduct().getProductId()) {
					int q = cart2.getQuantity() + cart.getQuantity();
					cart2.setQuantity(q);
					int p = q * cart2.getProduct().getProductPrice();
					cart2.setPrice_per_line(p);
					cartDao.save(cart2);
					return cart2;
				}

			}
			int p = cart.getQuantity() * cart.getProduct().getProductPrice();
			cart.setPrice_per_line(p);
			list.add(cart);
			user.setCart(list);
			userDao.save(user);
			return cart;
	}
	
	public List<Cart> getCartByUser(int userId){
		User user = userDao.findOne(userId);
				return user.getCart();
	}

}
