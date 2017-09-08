package org.bmsource.dao;

import java.util.Collection;

import javax.ejb.EJB;

import org.bmsource.bookstore.model.entity.Book;
import org.bmsource.service.BookstoreService;
import org.bmsource.service.impl.BookstoreServiceEjb;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class BookStoreServiceIT {

	@EJB(lookup = "java:global/test/BookstoreServiceEjb!org.bmsource.service.BookstoreService")
	BookstoreService bookstoreService;

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addPackages(true, "org.bmsource")
				.addAsResource("arq-persistence.xml", "META-INF/persistence.xml")
				.addAsResource("META-INF/sql/create.sql")
				.addAsResource("META-INF/sql/data.sql")
				.addAsResource("META-INF/sql/drop.sql")
				.addClass(BookstoreService.class)
				.addClass(BookstoreServiceEjb.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	public void testGetBooks() {
		Collection<Book> books = bookstoreService.getBooks();
		System.err.println("xxxxxxx");
		System.err.println("xxxxxxx");
		System.err.println("xxxxxxx");
		System.err.println("xxxxxxx");
		for (Book book : books) {
			System.err.println(book);
		}
		Assert.assertTrue(books.size() > 0);
	}
}
