package org.bmsource.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.transaction.Transactional;

import org.bmsource.bookstore.model.entity.Order;
import org.bmsource.dao.AuthorDAO;
import org.bmsource.dao.BookDAO;
import org.bmsource.dao.OrderDAO;
import org.bmsource.dao.UserDAO;
import org.bmsource.service.OrderService;

@Singleton
@Transactional
public class OrderServiceImpl implements OrderService {

	@EJB
	private BookDAO bookDAO;

	@EJB
	private AuthorDAO authorDAO;

	@EJB
	private UserDAO customerDAO;

	@EJB
	private OrderDAO orderDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.OrderService#testLazyEager()
	 */
	@Override
	public Collection<Order> testLazyEager() {
		System.out.println("testLazyEager");
		Collection<Order> orders = orderDAO.findAll();
		orders.forEach(order -> {
			System.out.println();
		});
		return null;
	}

}
