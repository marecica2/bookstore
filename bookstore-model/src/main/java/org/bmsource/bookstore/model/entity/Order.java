package org.bmsource.bookstore.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "\"ORDER\"")
@SequenceGenerator(name = "default_gen", sequenceName = "seq_order")
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

	// @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,
	// orphanRemoval = true, mappedBy = "order")
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID") // join column is in table for Order
	public Set<OrderProduct> orderProducts = new HashSet<>();

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

}
