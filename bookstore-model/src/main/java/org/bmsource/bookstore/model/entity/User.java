package org.bmsource.bookstore.model.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "seq_user")
@Table(name = "USER")
@NamedEntityGraph(name = "x1", attributeNodes = {})
public class User extends AbstractEntity {

	private static final long serialVersionUID = 3077576660823558691L;

	@Column(name = "LOGIN", unique = true)
	private String login;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Order> orders = new HashSet<>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID") })
	private Role role;

	@Embedded
	private Address address;

	@ElementCollection
	@MapKeyColumn(name = "SETTING_NAME")
	@Column(name = "SETTING_VALUE")
	@CollectionTable(name = "USER_SETTINGS")
	Map<String, String> settings = new HashMap<>();

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public Map<String, String> getSettings() {
		return settings;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
