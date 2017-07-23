package org.bmsource.bookstore.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(name = "STATE", length = 50)
	private String state;

	@Column(name = "CITY", length = 50)
	private String city;

	@Column(name = "ADDRESS", length = 100)
	private String address;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
