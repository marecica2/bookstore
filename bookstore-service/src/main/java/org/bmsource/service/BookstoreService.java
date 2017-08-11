package org.bmsource.service;

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

@Stateless
@Transactional
public class BookstoreService {

	@EJB
	private BookDAO bookDAO;

	@EJB
	private AuthorDAO authorDAO;

	@EJB
	private UserDAO customerDAO;

	@EJB
	private OrderDAO orderDAO;

	public Collection<Book> getBooks() {
		Collection<Book> books = bookDAO.findAll();
		books.stream().forEach(book -> book.getAuthors().size());
		return books;
	}

	public Book getBook(Long id) {
		Book book = bookDAO.byId(id);
		return book;
	}

	public Book createBook(Book book) {
		return bookDAO.create(book);
	}

	public Book updateBook(Book book) {
		return bookDAO.update(book);
	}

	public Collection<User> getCustomers() {
		Collection<User> customers = customerDAO.findAll();
		return customers;
	}

	public User getCustomer(Long id) {
		User customer = customerDAO.byId(id);
		return customer;
	}

	public User createCustomer(User customer) {
		return customerDAO.create(customer);
	}

	public User updateCustomer(User customer) {
		return customerDAO.update(customer);
	}

	public Collection<Order> getOrders() {
		Collection<Order> customers = orderDAO.findAll();
		return customers;
	}

	public Order getOrder(Long id) {
		Order customer = orderDAO.byId(id);
		return customer;
	}

	public Order createOrder(Order customer) {
		return orderDAO.create(customer);
	}

	public Order updateOrder(Order customer) {
		return orderDAO.update(customer);
	}
}
