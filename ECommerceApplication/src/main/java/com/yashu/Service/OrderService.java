package com.yashu.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yashu.Dao.OrderDao;
import com.yashu.Dao.ProductDao;
import com.yashu.Dao.UserDao;
import com.yashu.Model.Orders;
import com.yashu.Model.Product;
import com.yashu.Model.User;

@Service
@Transactional
public class OrderService {

	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	UserDao userDao;
	
	public List<Orders> getAllOrders(){
		return (List<Orders>) orderDao.findAll();
	}
	
	public void updateOrders(int orderId,Orders order){
		Orders order1 = orderDao.findOne(orderId);
		order1.setOrderStatus(order.getOrderStatus());
		order1.setOrderDate(order.getOrderDate());
		orderDao.save(order1);
	}
	
	public Orders findOrderById(int orderId){
		return orderDao.findOne(orderId);
	}
	
	public String findOrderStatusById(int id){
		
		return orderDao.findOne(id).getOrderStatus();
		 
	}
	
	public void addOrder(Orders order, int userId){
		
		/*List<Product> list=order.getListOfProducts();
		boolean b=true;
		for (Product product : list) {
			if(!productDao.exists(product.getProductId()))
				b=false;
		}
		if(b)
		*/	
		User user = userDao.findOne(userId);
		List<Orders> list = user.getUserOrders();
		
		Orders order1 = orderDao.save(order);
		list.add(order1);
		user.setUserOrders(list);
		userDao.save(user);
		
		
		
	}
	
	
}
