package org.bmsource.bookstore.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "CUST_ORDER")
public class Order extends AbstractEntity {

	public static enum Status {
		NEW, PAID, IN_PROGRESS, EXPEDITED, DELIVERED, CANCELLED
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", length = 32)
	private Status status = Status.NEW;

	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)
	private Customer customer;

	@OneToMany
	@JoinTable(name = "ORDER_BOOK", joinColumns = @JoinColumn(name = "ORDER_ID"), inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
	private Set<Book> books = new HashSet<>();

	public Set<Book> getBooks() {
		return books;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
