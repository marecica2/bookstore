package org.bmsource.bookstore.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "\"ORDER\"")
@SequenceGenerator(name = "default_gen", sequenceName = "seq_order")
@NamedEntityGraphs({
		@NamedEntityGraph(name = Order.PRODUCTS, attributeNodes = @NamedAttributeNode("orderProducts")),
		@NamedEntityGraph(name = Order.PRODUCTS_PRODUCT, attributeNodes = @NamedAttributeNode("orderProducts"), subgraphs = {
				@NamedSubgraph(name = Order.PRODUCTS_PRODUCT, attributeNodes = @NamedAttributeNode("product")) }),
		@NamedEntityGraph(name = Order.ALL, includeAllAttributes = true),
})
public class Order extends AbstractEntity {

	public static final String PRODUCTS = "graph.order.products";
	public static final String PRODUCTS_PRODUCT = "graph.order.products.product";
	public static final String USER = "graph.order.user";
	public static final String ALL = "graph.order.all";

	public static enum Status {
		NEW, PAID, IN_PROGRESS, EXPEDITED, DELIVERED, CANCELLED
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", length = 32)
	private Status status = Status.NEW;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	// unidirectional one to many without join table (possible since jpa 2.0)
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID")
	private Set<OrderProduct> orderProducts = new HashSet<>();

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	@Override
	public String toString() {
		return "Order [status=" + status + ", id=" + id + "]";
	}
}
