package org.bmsource.dto;

import org.bmsource.bookstore.model.entity.Pk;
import org.bmsource.bookstore.model.util.Color;

public class OrderProductDTO {
	private Color color;

	private Pk id;

	private ProductDTO product;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Pk getId() {
		return id;
	}

	public void setId(Pk id) {
		this.id = id;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

}
