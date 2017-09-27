package org.bmsource.service;

import javax.ejb.Remote;

@Remote
public interface Counter {

	public int count();

	public int increment();

	public int reset();

	public void remove();
}