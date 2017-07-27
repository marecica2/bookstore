package org.bmsource.service;

import java.util.Collection;

import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.transaction.Transactional;

import org.bmsource.bookstore.model.entity.Order;
import org.bmsource.dao.AuthorDAO;
import org.bmsource.dao.BookDAO;
import org.bmsource.dao.CustomerDAO;
import org.bmsource.dao.OrderDAO;

@Singleton
@DependsOn("DataGeneratorService")
@Transactional
public class OrderService {

	@EJB
	private BookDAO bookDAO;

	@EJB
	private AuthorDAO authorDAO;

	@EJB
	private CustomerDAO customerDAO;

	@EJB
	private OrderDAO orderDAO;

	public Collection<Order> testLazyEager() {
		Collection<Order> orders = orderDAO.findAll();
		orders.forEach(order -> {
			System.out.println(order);
			System.out.println(order.getOrderProducts());
		});
		return orders;
	}

}
