package org.bmsource.bookstore.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Book extends AbstractEntity {

	@NotNull
	@Column(name = "TITLE")
	private String title;

	@NotNull
	@Column(name = "ISBN")
	private String isbn;

	@ManyToMany
	@JoinTable(name = "BOOK_AUTHOR")
	private Set<Author> authors = new HashSet<>();

	public Set<Author> getAuthors() {
		return authors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", isbn=" + isbn + "]";
	}

}
