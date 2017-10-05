package org.bmsource.service;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BookstoreException extends Exception {

	private static final long serialVersionUID = 520590426966771970L;

	private String message;

	public BookstoreException() {
		super();
	}

	public BookstoreException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public BookstoreException(String message) {
		super(message);
		this.message = message;
	}

	public BookstoreException(Throwable cause) {
		super(cause);
	}

	@Override
	public String getMessage() {
		return message;
	}
}
