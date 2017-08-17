package org.bmsource.dao;

import javax.ejb.Stateless;

import org.bmsource.bookstore.model.entity.User;

@Stateless
public class UserDAO extends AbstractDAO<User> {

	public UserDAO() {
		super();
		setType(User.class);
	}

}
