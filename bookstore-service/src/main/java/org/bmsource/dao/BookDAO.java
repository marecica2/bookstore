package org.bmsource.dao;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.bmsource.bookstore.model.entity.Book;

@Stateless
public class BookDAO extends AbstractDAO<Book> {

	public BookDAO() {
		super();
		setType(Book.class);
	}

	@Override
	public Collection<Book> findAll() {
		CriteriaQuery<Book> cq = entityManager.getCriteriaBuilder().createQuery(Book.class);
		Root<Book> rootEntry = cq.from(Book.class);

		CriteriaQuery<Book> all = cq.select(rootEntry);
		TypedQuery<Book> allQuery = entityManager.createQuery(all);

		List<Book> books = allQuery.getResultList();
		books.stream().forEach(book -> book.getAuthors());
		return books;
	}
}
