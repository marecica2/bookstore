package org.bmsource.bookstore.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("BOOK")
@Table(name = "PRODUCT_BOOK")

@NamedEntityGraph(name = Book.FULL, attributeNodes = { @NamedAttributeNode("authors"), @NamedAttributeNode("content") })
public class Book extends Product {

	private static final long serialVersionUID = -4647005664336194152L;

	public static final String FULL = "Book.full";

	@NotNull
	@Column(name = "ISBN")
	private String isbn;

	@ManyToMany
	@OrderColumn
	@JoinTable(name = "BOOK_AUTHOR")
	private Set<Author> authors = new HashSet<>();

	public Set<Author> getAuthors() {
		return authors;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
