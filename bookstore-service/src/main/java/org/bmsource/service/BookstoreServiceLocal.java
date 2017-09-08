package org.bmsource.service;

import java.util.Collection;

import javax.ejb.Local;

import org.bmsource.bookstore.model.entity.Book;
import org.bmsource.bookstore.model.entity.Order;
import org.bmsource.bookstore.model.entity.User;

@Local
public interface BookstoreServiceLocal {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#getBooks()
	 */
	Collection<Book> getBooks();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#getBook(java.lang.Long)
	 */
	Book getBook(Long id);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#createBook(org.bmsource.
	 * bookstore.model.entity.Book)
	 */
	Book createBook(Book book);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#updateBook(org.bmsource.
	 * bookstore.model.entity.Book)
	 */
	Book updateBook(Book book);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#getCustomers()
	 */
	Collection<User> getCustomers();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.bmsource.service.impl.BookstoreService#getCustomer(java.lang.Long)
	 */
	User getCustomer(Long id);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.bmsource.service.impl.BookstoreService#createCustomer(org.bmsource.
	 * bookstore.model.entity.User)
	 */
	User createCustomer(User customer);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.bmsource.service.impl.BookstoreService#updateCustomer(org.bmsource.
	 * bookstore.model.entity.User)
	 */
	User updateCustomer(User customer);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#getOrders()
	 */
	Collection<Order> getOrders();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#getOrder(java.lang.Long)
	 */
	Order getOrder(Long id);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#createOrder(org.bmsource.
	 * bookstore.model.entity.Order)
	 */
	Order createOrder(Order customer);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bmsource.service.impl.BookstoreService#updateOrder(org.bmsource.
	 * bookstore.model.entity.Order)
	 */
	Order updateOrder(Order customer);

}