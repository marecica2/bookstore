package org.bmsource.service.impl;

import java.math.BigDecimal;
import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.bmsource.bookstore.model.entity.Book;
import org.bmsource.bookstore.model.entity.Order;
import org.bmsource.bookstore.model.entity.Order.Status;
import org.bmsource.bookstore.model.entity.User;
import org.bmsource.dao.AuthorDAO;
import org.bmsource.dao.BookDAO;
import org.bmsource.dao.OrderDAO;
import org.bmsource.dao.UserDAO;
import org.bmsource.logging.Loggable;
import org.bmsource.service.BookstoreException;
import org.bmsource.service.BookstoreService;
import org.bmsource.service.BookstoreServiceLocal;
import org.bmsource.service.CreditCardPayment;

@Loggable
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class BookstoreServiceEjb implements BookstoreService, BookstoreServiceLocal {

	@EJB
	private BookDAO bookDAO;

	@EJB
	private AuthorDAO authorDAO;

	@EJB
	private UserDAO userDAO;

	@EJB
	private OrderDAO orderDAO;

	@EJB
	private InvoiceProducerEjb invoiceProducer;

	@EJB
	private EventProducerEjb eventProducer;

	@EJB
	private CreditCardPayment creditCardPayment;

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
	public Collection<User> getUsers() {
		Collection<User> customers = userDAO.findAll();
		return customers;
	}

	@Override
	public User getUser(Long id) {
		User customer = userDAO.byId(id);
		return customer;
	}

	@Override
	public User createUser(User user) {
		return userDAO.create(user);
	}

	@Override
	public User updateUser(User user) {
		return userDAO.update(user);
	}

	@Override
	public Collection<Order> getOrders() {
		Collection<Order> customers = orderDAO.findAll();
		return customers;
	}

	@Override
	public Order getOrder(Long id) {
		Order order = orderDAO.byId(id, Order.ALL);
		return order;
	}

	@Override
	public Order createOrder(Order order) {
		return orderDAO.create(order);
	}

	@Override
	public Order updateOrder(Order order) {
		return orderDAO.update(order);
	}

	@Override
	public Order submitOrder(Order order, boolean rollback) throws BookstoreException {
		order = orderDAO.getEntityManager().merge(order);

		BigDecimal total = new BigDecimal(0);
		order.getOrderProducts().forEach(o -> total.add(BigDecimal.valueOf(o.getProduct().getId())));
		order.setStatus(Status.PAID);
		order.setLastModifiedDate();
		orderDAO.update(order);
		invoiceProducer.sendInvoice(
				"DE0001" + order.getUser().getLogin() + "123 " + total + " USD " + order.getLastModifiedDate());
		eventProducer.createEvent("Invoice was created on " + order.getLastModifiedDate());
		creditCardPayment.charge("DE0001" + order.getUser().getLogin() + "123", total, rollback);
		return order;
	}

}
