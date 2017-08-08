package org.bmsource.bookstore.model.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.bmsource.bookstore.model.util.Color;
import org.bmsource.bookstore.model.util.ColorConverter;

@Entity
@Table(name = "ORDER_PRODUCT")
public class OrderProduct {

	private Integer quantity = 1;

	@Column(name = "COLOR")

	@Convert(converter = ColorConverter.class)
	private Color color;

	@EmbeddedId
	private Pk id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
	@MapsId("productId")
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("orderId")
	@JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")
	private Order order;

	public OrderProduct() {
		super();
		this.id = new Pk();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
		this.id.orderId = order.getId();
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
		this.id.productId = product.getId();
	}

	@Override
	public String toString() {
		return "OrderProduct [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderProduct other = (OrderProduct) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
