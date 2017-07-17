package org.bmsource.dao;

import javax.ejb.Stateless;

import org.bmsource.bookstore.model.entity.Customer;

@Stateless
public class CustomerDAO extends AbstractDAO<Customer> {

	public CustomerDAO() {
		super();
		setType(Customer.class);
	}

}
