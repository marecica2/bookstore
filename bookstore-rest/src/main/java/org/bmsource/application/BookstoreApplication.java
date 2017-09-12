package org.bmsource.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.bmsource.resources.AsyncResource;
import org.bmsource.resources.BookResource;
import org.bmsource.resources.CustomerResource;
import org.bmsource.resources.OrderResource;

@ApplicationPath("/bookstore")
public class BookstoreApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(BookResource.class);
		classes.add(CustomerResource.class);
		classes.add(OrderResource.class);
		classes.add(AsyncResource.class);
		return classes;
	}
}
