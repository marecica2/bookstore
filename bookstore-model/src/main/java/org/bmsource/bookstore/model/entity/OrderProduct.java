package org.bmsource.bookstore.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_PRODUCT")
@SequenceGenerator(name = "default_gen", sequenceName = "seq_order_seq")
public class OrderProduct extends AbstractEntity {

	private Integer quantity = 1;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
	private Product product;

	public OrderProduct() {
		super();
	}

	public OrderProduct(Integer quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
