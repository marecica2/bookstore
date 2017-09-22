package org.bmsource.service.impl;

import java.util.concurrent.TimeUnit;

import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

import org.bmsource.service.Counter;

@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 20)
public class CounterEjb implements Counter {

	private int count = 0;

	@Override
	public int count() {
		return count;
	}

	@Override
	public int increment() {
		return ++count;
	}

	@Override
	public int reset() {
		return (count = 0);
	}
}
