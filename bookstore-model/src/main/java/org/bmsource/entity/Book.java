package org.bmsource.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Book extends AbstractEntity {

	@Column(name = "TITLE")
	private String title;

	@Column(name = "ISBN")
	private String isbn;

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
