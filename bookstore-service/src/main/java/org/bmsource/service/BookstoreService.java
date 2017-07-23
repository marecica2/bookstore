package org.bmsource.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import org.bmsource.bookstore.model.entity.Book;
import org.bmsource.bookstore.model.entity.Customer;
import org.bmsource.dao.AuthorDAO;
import org.bmsource.dao.BookDAO;
import org.bmsource.dao.CustomerDAO;
import org.bmsource.dao.OrderDAO;

@Stateless
@Transactional
public class BookstoreService {

	@EJB
	private BookDAO bookDAO;

	@EJB
	private AuthorDAO authorDAO;

	@EJB
	private CustomerDAO customerDAO;

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

	public Collection<Customer> getCustomers() {
		Collection<Customer> customers = customerDAO.findAll();
		return customers;
	}

	public Customer getCustomer(Long id) {
		Customer customer = customerDAO.byId(id);
		return customer;
	}

	public Customer createCustomer(Customer customer) {
		return customerDAO.create(customer);
	}

	public Customer updateCustomer(Customer customer) {
		return customerDAO.update(customer);
	}

}
