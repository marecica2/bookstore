package org.bmsource.service.impl;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

import org.bmsource.logging.Loggable;
import org.bmsource.service.Async;

@Singleton
@Loggable
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class AsyncEjb implements Async {

	@Override
	@PostConstruct
	public void init() {
		System.out.println("ASYNC EJB STARTED");
	}

	@Override
	@AccessTimeout(0)
	public void doItNow() {
	}

	@Override
	@AccessTimeout(value = 7, unit = TimeUnit.SECONDS)
	public void doItSoon() {
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(4));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	@AccessTimeout(-1)
	public void justDoIt() {
	}
}
