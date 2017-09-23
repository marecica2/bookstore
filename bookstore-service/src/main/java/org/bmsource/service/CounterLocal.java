package org.bmsource.service;

import javax.ejb.Local;

@Local
public interface CounterLocal {

	public int count();

	public int increment();

	public int reset();
}