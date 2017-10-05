package org.bmsource.dao;

import java.math.BigDecimal;
import java.util.Collection;

import javax.inject.Inject;
import javax.naming.NamingException;
import javax.persistence.EntityTransaction;

import org.bmsource.bookstore.model.entity.Book;
import org.bmsource.bookstore.model.entity.Content;
import org.jboss.weld.junit4.WeldInitiator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

public class BookDAOTest extends AbstractDAOTest {

	@Rule
	public WeldInitiator weld = WeldInitiator.from(BookDAO.class).inject(this).build();

	@Inject
	private BookDAO bookDAO;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("BookDAOTest@BeforeClass");
	}

	@Before
	public void before() {
		bookDAO.setEntityManager(entityManager);
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("BookDAOTest@AfterClass");
	}

	@Test
	public void testGetByIdTest() throws NamingException {
		Book book = bookDAO.byId(1L);
		Assert.assertNotNull(book);
	}

	@Test
	public void testFindAll() throws NamingException {
		Collection<Book> books = bookDAO.findAll();
		Assert.assertTrue(books.size() > 0);
	}

	@Test
	public void testCreate() throws NamingException {
		String testDescription = "Test";
		Content content = new Content();
		content.setContent(testDescription.getBytes());
		content.setContentType("text");

		Book book = new Book();
		book.setPrice(new BigDecimal(10.89));
		book.setContent(content);
		book.setIsbn("ISBN" + System.currentTimeMillis());
		book.setDescription(testDescription);
		book.setName(testDescription);

		EntityTransaction t2 = entityManager.getTransaction();
		t2.begin();
		bookDAO.create(book);
		t2.commit();

		Assert.assertTrue(book.getId() > 0);
	}

}
