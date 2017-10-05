package org.bmsource.service.impl;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.bmsource.logging.Loggable;
import org.bmsource.service.BookstoreException;
import org.bmsource.service.CreditCardPayment;

@Loggable
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
public class CreditCardPaymentEjb implements CreditCardPayment {

	@Resource
	SessionContext ctx;

	@Override
	public void charge(String credictCard, BigDecimal amount, boolean fail) throws BookstoreException {
		System.out.println("Calling external payment system");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (fail) {
			ctx.setRollbackOnly();
			throw new BookstoreException("Error occured while executing payment");
		}
		System.out.println("Payment executed successfully");
	}

}
