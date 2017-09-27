package org.bmsource.service.impl;

import java.rmi.RemoteException;
import java.util.concurrent.TimeUnit;

import javax.ejb.AfterBegin;
import javax.ejb.AfterCompletion;
import javax.ejb.BeforeCompletion;
import javax.ejb.EJBException;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

import org.bmsource.service.Counter;
import org.bmsource.service.CounterLocal;

@Stateful(passivationCapable = true)
@StatefulTimeout(unit = TimeUnit.SECONDS, value = 30)
public class CounterEjb implements Counter, CounterLocal {

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

	@PostActivate
	public void postActivate() {
		System.out.println("postActivate");
	}

	@PrePassivate
	public void prePassivate() {
		System.out.println("prePassivate");
	}

	@Remove
	@Override
	public void remove() {
		System.out.println("Will remove.");
	}

	// *********** SessionSynchronization *******************************
	@AfterBegin
	public void afterBegin() throws EJBException, RemoteException {
		System.out.println("AfterBegin");
	}

	@BeforeCompletion
	public void beforeCompletion() throws EJBException, RemoteException {
		System.out.println("beforeCompletion");
	}

	@AfterCompletion
	public void afterCompletion(boolean committed) throws EJBException, RemoteException {
		System.out.println("afterCompletion");
	}
}
