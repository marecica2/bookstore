package org.bmsource.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import org.bmsource.bookstore.model.entity.Book;
import org.bmsource.dao.AuthorDAO;
import org.bmsource.dao.BookDAO;
import org.bmsource.dao.CustomerDAO;
import org.bmsource.dao.OrderDAO;

@Transactional
@Stateless
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
		return bookDAO.findAll();
	}

	public Book getBook(Long id) {
		return bookDAO.byId(id);
	}

	public Book saveBook(Book book) {
		return bookDAO.save(book);
	}

}
