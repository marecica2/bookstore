package org.bmsource.service;

import java.util.Collection;

import org.bmsource.bookstore.model.entity.Order;

public interface OrderService {

	Collection<Order> testLazyEager();

}