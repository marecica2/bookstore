package org.bmsource.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.bmsource.dao.BookDAO;
import org.bmsource.entity.Book;

@Stateless
public class BookService {

	@EJB
	BookDAO bookDAO;

	public Book getById(Long id) {
		return bookDAO.findById(id);
	}

	public Book saveBook(Book book) {
		return bookDAO.saveBook(book);
	}

}
