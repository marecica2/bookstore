package org.bmsource.service.impl;

import javax.naming.Context;

import org.bmsource.service.Counter;
import org.bmsource.service.CounterLocal;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import junit.framework.TestCase;

@RunWith(Arquillian.class)
public class CounterTest extends TestCase {

	@ArquillianResource
	private Context context;

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addClass(Counter.class)
				.addClass(CounterEjb.class)
				.addClass(CounterLocal.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	public void test() throws Exception {

		Counter counterA = (Counter) context.lookup(
				"java:global/test/CounterEjb!org.bmsource.service.Counter");

		assertEquals(0, counterA.count());
		assertEquals(0, counterA.reset());
		assertEquals(1, counterA.increment());
		assertEquals(2, counterA.increment());
		assertEquals(0, counterA.reset());

		counterA.increment();
		counterA.increment();
		counterA.increment();
		counterA.increment();

		assertEquals(4, counterA.count());

		// Get a new counter
		Counter counterB = (Counter) context.lookup("java:global/test/CounterEjb!org.bmsource.service.Counter");

		// The new bean instance starts out at 0
		assertEquals(0, counterB.count());
		counterA.remove();
		counterB.remove();
	}

}
