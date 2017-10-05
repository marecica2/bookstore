package org.bmsource.service;

import java.math.BigDecimal;

public interface CreditCardPayment {

	void charge(String credictCard, BigDecimal amount, boolean fail) throws BookstoreException;

}