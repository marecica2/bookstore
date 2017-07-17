package org.bmsource.dao;

import javax.ejb.Stateless;

import org.bmsource.bookstore.model.entity.Author;

@Stateless
public class AuthorDAO extends AbstractDAO<Author> {

	public AuthorDAO() {
		super();
		setType(Author.class);
	}
}
