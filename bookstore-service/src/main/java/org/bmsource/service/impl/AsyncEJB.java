package org.bmsource.service.impl;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class AsyncEJB {
	@PostConstruct
	public void init() {
		System.out.println("ASYNC EJB STARTED");
	}

	@AccessTimeout(0)
	public void doItNow() {
		// do something
	}

	@AccessTimeout(value = 5, unit = TimeUnit.SECONDS)
	public void doItSoon() {
		// do something
	}

	@AccessTimeout(-1)
	public void justDoIt() {
		// do something
	}
}
