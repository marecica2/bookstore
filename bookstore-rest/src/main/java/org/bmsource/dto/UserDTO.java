package org.bmsource.dto;

import java.util.HashMap;
import java.util.Map;

import org.bmsource.bookstore.model.entity.Address;

public class UserDTO {
	private String login;

	private String firstName;

	private String lastName;

	private Address address;

	Map<String, String> settings = new HashMap<>();

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Map<String, String> getSettings() {
		return settings;
	}

	public void setSettings(Map<String, String> settings) {
		this.settings = settings;
	}

}
