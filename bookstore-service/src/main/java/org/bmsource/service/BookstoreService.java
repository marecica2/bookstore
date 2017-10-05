package org.bmsource.service;

import java.util.Collection;

import javax.ejb.Remote;

import org.bmsource.bookstore.model.entity.Book;
import org.bmsource.bookstore.model.entity.Order;
import org.bmsource.bookstore.model.entity.User;

@Remote
public interface BookstoreService {

	Collection<Book> getBooks();

	Book getBook(Long id);

	Book createBook(Book book);

	Book updateBook(Book book);

	Collection<User> getUsers();

	User getUser(Long id);

	User createUser(User user);

	User updateUser(User user);

	Collection<Order> getOrders();

	Order getOrder(Long id);

	Order createOrder(Order order);

	Order updateOrder(Order order);

	Order submitOrder(Order order, boolean rollback) throws BookstoreException;
}