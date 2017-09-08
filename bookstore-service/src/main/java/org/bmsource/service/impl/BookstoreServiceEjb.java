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
import org.bmsource.service.BookstoreService;
import org.bmsource.service.BookstoreServiceLocal;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#getBooks()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#getBooks()
	 */
	@Override
	public Collection<Book> getBooks() {
		Collection<Book> books = bookDAO.findAll();
		books.stream().forEach(book -> book.getAuthors().size());
		return books;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#getBook(java.lang.Long)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#getBook(java.lang.Long)
	 */
	@Override
	public Book getBook(Long id) {
		Book book = bookDAO.byId(id);
		return book;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#createBook(org.bmsource.
	 * bookstore.model.entity.Book)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#createBook(org.bmsource.
	 * bookstore.model.entity.Book)
	 */
	@Override
	public Book createBook(Book book) {
		return bookDAO.create(book);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#updateBook(org.bmsource.
	 * bookstore.model.entity.Book)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#updateBook(org.bmsource.
	 * bookstore.model.entity.Book)
	 */
	@Override
	public Book updateBook(Book book) {
		return bookDAO.update(book);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#getCustomers()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#getCustomers()
	 */
	@Override
	public Collection<User> getCustomers() {
		Collection<User> customers = customerDAO.findAll();
		return customers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.bmsource.service.impl.BookstoreService#getCustomer(java.lang.Long)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.bmsource.service.impl.BookstoreService#getCustomer(java.lang.Long)
	 */
	@Override
	public User getCustomer(Long id) {
		User customer = customerDAO.byId(id);
		return customer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.bmsource.service.impl.BookstoreService#createCustomer(org.bmsource.
	 * bookstore.model.entity.User)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.bmsource.service.impl.BookstoreService#createCustomer(org.bmsource.
	 * bookstore.model.entity.User)
	 */
	@Override
	public User createCustomer(User customer) {
		return customerDAO.create(customer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.bmsource.service.impl.BookstoreService#updateCustomer(org.bmsource.
	 * bookstore.model.entity.User)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.bmsource.service.impl.BookstoreService#updateCustomer(org.bmsource.
	 * bookstore.model.entity.User)
	 */
	@Override
	public User updateCustomer(User customer) {
		return customerDAO.update(customer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#getOrders()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#getOrders()
	 */
	@Override
	public Collection<Order> getOrders() {
		Collection<Order> customers = orderDAO.findAll();
		return customers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#getOrder(java.lang.Long)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#getOrder(java.lang.Long)
	 */
	@Override
	public Order getOrder(Long id) {
		Order customer = orderDAO.byId(id);
		return customer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#createOrder(org.bmsource.
	 * bookstore.model.entity.Order)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#createOrder(org.bmsource.
	 * bookstore.model.entity.Order)
	 */
	@Override
	public Order createOrder(Order customer) {
		return orderDAO.create(customer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#updateOrder(org.bmsource.
	 * bookstore.model.entity.Order)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#updateOrder(org.bmsource.
	 * bookstore.model.entity.Order)
	 */
	@Override
	public Order updateOrder(Order customer) {
		return orderDAO.update(customer);
	}
}
