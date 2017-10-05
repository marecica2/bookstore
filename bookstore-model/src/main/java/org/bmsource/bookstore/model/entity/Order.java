package org.bmsource.bookstore.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
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
		@NamedNativeQuery(name = Order.NAMED_QUERY, query = "select op.product_id as productId, o.user_id as userId, o.version as version, o.createdDate as createdDate, o.lastModifiedDate as lastModifiedDate, o.id as orderId, o.status as orderStatus from bookstore.`ORDER` o LEFT OUTER JOIN bookstore.ORDER_PRODUCT op on op.ORDER_ID = o.ID", resultSetMapping = Order.SQL_RESULT_SET_MAPPING_BASIC) })

@SqlResultSetMappings({
		@SqlResultSetMapping(name = Order.SQL_RESULT_SET_MAPPING_BASIC, entities = {
				@EntityResult(entityClass = Order.class, fields = {
						@FieldResult(name = "user", column = "userId"),
						@FieldResult(name = "version", column = "version"),
						@FieldResult(name = "createdDate", column = "createdDate"),
						@FieldResult(name = "lastModifiedDate", column = "lastModifiedDate"),
						@FieldResult(name = "id", column = "orderId"),
						@FieldResult(name = "status", column = "orderStatus")
				}) },

				classes = { @ConstructorResult(targetClass = OrderProduct.class, columns = {
						@ColumnResult(name = "orderId", type = Long.class),
						@ColumnResult(name = "productId", type = Long.class)
				}) }

		)
})
public class Order extends AbstractEntity {

	private static final long serialVersionUID = -242469463809682959L;

	public static final String SQL_RESULT_SET_MAPPING_BASIC = "basic";
	public static final String PRODUCTS = "graph.order.products";
	public static final String PRODUCTS_PRODUCT = "graph.order.products.product";
	public static final String USER = "graph.order.user";
	public static final String ALL = "graph.order.all";
	public static final String NAMED_QUERY = "findAllProducts";

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

	public void setOrderProducts(Set<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	@Override
	public String toString() {
		return "Order [status=" + status + ", id=" + id + "]";
	}
}
