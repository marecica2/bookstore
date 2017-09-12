package org.bmsource.service;

import javax.ejb.Remote;

@Remote
public interface Async {

	void init();

	void doItNow();

	void doItSoon();

	void justDoIt();

}