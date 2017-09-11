package org.bmsource.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import org.bmsource.bookstore.model.entity.Book;
import org.bmsource.bookstore.model.entity.Order;
import org.bmsource.bookstore.model.entity.User;
import org.bmsource.dao.AuthorDAO;
import org.bmsource.dao.BookDAO;
import org.bmsource.dao.OrderDAO;
import org.bmsource.dao.UserDAO;
import org.bmsource.logging.Loggable;
import org.bmsource.service.BookstoreService;
import org.bmsource.service.BookstoreServiceLocal;

@Loggable
@Stateless
@Transactional
public class BookstoreServiceEjb implements BookstoreService, BookstoreServiceLocal {

	@EJB
	private BookDAO bookDAO;

	@EJB
	private AuthorDAO authorDAO;

	@EJB
	private UserDAO customerDAO;

	@EJB
	private OrderDAO orderDAO;

	@Override
	public Collection<Book> getBooks() {
		Collection<Book> books = bookDAO.findAll();
		return books;
	}

	@Override
	public Book getBook(Long id) {
		Book book = bookDAO.byId(id, Book.FULL);
		book.getAuthors().size();
		book.getContent();
		return book;
	}

	@Override
	public Book createBook(Book book) {
		return bookDAO.create(book);
	}

	@Override
	public Book updateBook(Book book) {
		return bookDAO.update(book);
	}

	@Override
	public Collection<User> getCustomers() {
		Collection<User> customers = customerDAO.findAll();
		return customers;
	}

	@Override
	public User getCustomer(Long id) {
		User customer = customerDAO.byId(id);
		return customer;
	}

	@Override
	public User createCustomer(User customer) {
		return customerDAO.create(customer);
	}

	@Override
	public User updateCustomer(User customer) {
		return customerDAO.update(customer);
	}

	@Override
	public Collection<Order> getOrders() {
		Collection<Order> customers = orderDAO.findAll();
		return customers;
	}

	@Override
	public Order getOrder(Long id) {
		Order customer = orderDAO.byId(id);
		return customer;
	}

	@Override
	public Order createOrder(Order customer) {
		return orderDAO.create(customer);
	}

	@Override
	public Order updateOrder(Order customer) {
		return orderDAO.update(customer);
	}
}
