package org.bmsource.service;

import java.util.Collection;

import javax.ejb.Remote;

import org.bmsource.bookstore.model.entity.Order;

@Remote
public interface OrderService {

	Collection<Order> testLazyEager();

}