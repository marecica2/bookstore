package org.bmsource.dao;

import javax.ejb.Stateless;

import org.bmsource.bookstore.model.entity.Order;

@Stateless
public class OrderDAO extends AbstractDAO<Order> {

	public OrderDAO() {
		super();
		setType(Order.class);
	}

}
