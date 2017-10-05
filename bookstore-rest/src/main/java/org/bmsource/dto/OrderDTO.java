package org.bmsource.dto;

import java.util.HashSet;
import java.util.Set;

import org.bmsource.bookstore.model.entity.Order.Status;

public class OrderDTO {
	private Status status;

	private UserDTO user;

	private Set<OrderProductDTO> orderProducts = new HashSet<>();

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Set<OrderProductDTO> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(Set<OrderProductDTO> orderProducts) {
		this.orderProducts = orderProducts;
	}
}
