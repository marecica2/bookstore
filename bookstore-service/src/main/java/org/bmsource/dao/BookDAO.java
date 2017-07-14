package org.bmsource.dao;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Stateless;

import org.bmsource.entity.Book;

@Stateless
@Startup
public class BookDAO extends AbstractDAO {

	public Book saveBook(Book book) {
		entityManager.persist(book);
		entityManager.flush();
		return book;
	}

	public Book findById(Long id) {
		return entityManager.find(Book.class, id);
	}

	@PostConstruct
	public void create() {
		System.err.println("EEEEEEEEE");
		Book book = new Book();
		book.setIsbn("ISBN");
		book.setTitle("Title");
		entityManager.persist(book);
		entityManager.flush();
		System.err.println("EEEEEEEEE");
	}
}
