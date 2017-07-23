package org.bmsource.bookstore.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "seq_customer")
@Table(name = "CUSTOMER")
public class Customer extends AbstractEntity {

	@Column(name = "LOGIN", unique = true)
	private String login;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL, mappedBy = "customer")
	private Set<Order> orders = new HashSet<>();

	@Embedded
	private Address address;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Set<Order> getOrders() {
		return orders;
	}
}
