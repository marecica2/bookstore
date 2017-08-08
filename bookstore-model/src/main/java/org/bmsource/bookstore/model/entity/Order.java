package org.bmsource.bookstore.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.FieldResult;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

@Cacheable
@Entity
@Table(name = "\"ORDER\"")
@SequenceGenerator(name = "default_gen", sequenceName = "seq_order")

@NamedEntityGraphs({
		@NamedEntityGraph(name = Order.PRODUCTS, attributeNodes = @NamedAttributeNode("orderProducts")),
		@NamedEntityGraph(name = Order.PRODUCTS_PRODUCT, attributeNodes = @NamedAttributeNode(value = "orderProducts", subgraph = "xxx"), subgraphs = {
				@NamedSubgraph(name = "xxx", attributeNodes = @NamedAttributeNode("product")) }),
		@NamedEntityGraph(name = Order.ALL, includeAllAttributes = true),
})

@NamedNativeQueries({
		@NamedNativeQuery(name = Order.NAMED_NATIVE_QUERY_ORDERS_SIMPLE, query = "select o.user_id as user_id, o.version as version, o.createdDate as createdDate, o.lastModifiedDate as lastModifiedDate, o.id as order_id, o.status as order_status from bookstore.`ORDER` o", resultSetMapping = Order.SQL_RESULT_SET_MAPPING_BASIC) })

@SqlResultSetMappings({
		@SqlResultSetMapping(name = Order.SQL_RESULT_SET_MAPPING_BASIC, entities = {
				@EntityResult(entityClass = Order.class, fields = {
						@FieldResult(name = "user", column = "user_id"),
						@FieldResult(name = "version", column = "version"),
						@FieldResult(name = "createdDate", column = "createdDate"),
						@FieldResult(name = "lastModifiedDate", column = "lastModifiedDate"),
						@FieldResult(name = "id", column = "order_id"),
						@FieldResult(name = "status", column = "order_status")
				}) }

		)
})
public class Order extends AbstractEntity {

	public static final String SQL_RESULT_SET_MAPPING_BASIC = "basic";
	public static final String NAMED_NATIVE_QUERY_ORDERS_SIMPLE = "find.all.products";
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
