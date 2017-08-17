package org.bmsource.dao;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.naming.NamingException;
import javax.persistence.Cache;
import javax.persistence.CacheRetrieveMode;
import javax.persistence.EntityTransaction;
import javax.persistence.OptimisticLockException;
import javax.persistence.Tuple;

import org.bmsource.bookstore.model.entity.Book;
import org.bmsource.bookstore.model.entity.Order;
import org.bmsource.bookstore.model.entity.Order.Status;
import org.bmsource.bookstore.model.entity.Product;
import org.bmsource.bookstore.model.util.Color;
import org.hibernate.LazyInitializationException;
import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class OrderDAOTest extends AbstractDAOTest {

	@Rule
	public WeldInitiator weld = WeldInitiator.from(OrderDAO.class).inject(this).build();

	@Inject
	private OrderDAO orderDAO;

	@Before
	public void before() {
		orderDAO.setEntityManager(entityManager);
	}

	@Test
	public void testFindByIdFetchGraph() {
		Order order = orderDAO.byId(1L, Order.PRODUCTS_PRODUCT);
		orderDAO.getEntityManager().clear();

		Order order1 = orderDAO.byId(1L, Order.PRODUCTS);
		orderDAO.getEntityManager().clear();

		Order order2 = orderDAO.byId(1L, Order.ALL);
		orderDAO.getEntityManager().clear();

		Assert.assertNotNull(order.getOrderProducts().iterator().next().getProduct().getName());
		Assert.assertNotNull(order1.getOrderProducts());
		Assert.assertNotNull(order2.getOrderProducts());
	}

	@Test(expected = LazyInitializationException.class)
	public void testWithoutFetchGraph() {
		Order order3 = orderDAO.byId(1L);
		orderDAO.getEntityManager().clear();
		Assert.assertNull(order3.getOrderProducts());
	}

	@Test
	public void testFindOrderForGivenBook() throws NamingException {
		Book book = new Book();
		book.setName("As I Lay Dying");

		Collection<Order> orders = orderDAO.findForBook(book);
		Assert.assertEquals(4, orders.size());
	}

	@Test
	public void testColorConversion() {
		Color color = new Color(50, 50, 50);
		EntityTransaction t = orderDAO.getEntityManager().getTransaction();

		t.begin();
		Order order = orderDAO.byId(1L, Order.PRODUCTS_PRODUCT);
		order.getOrderProducts().iterator().next().setColor(color);
		orderDAO.update(order);
		t.commit();

		orderDAO.getEntityManager().clear();
		Order order2 = orderDAO.byId(1L, Order.PRODUCTS_PRODUCT);
		Assert.assertEquals(color,
				order2.getOrderProducts().iterator().next().getColor());
	}

	@Test
	public void testTupleQuery() {
		List<Tuple> tuples = orderDAO.findAllOrdersWithProducts();
		for (Tuple tuple : tuples) {
			System.out.println(tuple.get(0, Order.class));
			System.out.println(tuple.get(1, Product.class));
		}
		Assert.assertTrue(tuples.size() > 0);
	}

	@Test(expected = LazyInitializationException.class)
	public void testFetchQuery() {
		System.out.println("Fetch");
		Order order1 = orderDAO.byIdFetch(1L);
		System.out.println("Classic");
		orderDAO.getEntityManager().clear();

		Order order2 = orderDAO.byId(1L);
		order1.getOrderProducts();

		orderDAO.getEntityManager().clear();
		Assert.assertTrue(order1.getOrderProducts().size() > 0);
		Assert.assertNull(order2.getOrderProducts());
	}

	@Test
	public void testCache() {
		// TODO not working cache
		orderDAO.getEntityManager().setProperty(
				"javax.persistence.cache.retrieveMode", CacheRetrieveMode.USE);

		EntityTransaction t = orderDAO.getEntityManager().getTransaction();

		t.begin();
		orderDAO.byId(1L);
		t.commit();

		Cache cache = orderDAO.getEntityManager().getEntityManagerFactory().getCache();
		boolean contains = cache.contains(Order.class, 1L);

		t.begin();
		Order order2 = orderDAO.byId(1L);
		t.commit();
		Assert.assertNotNull(order2);
	}

	@Test
	public void testNativeQueryResultMapping() {
		List<Object[]> orders = orderDAO.namedNativeQueryResultsetMapping();
		Assert.assertTrue(orders.size() > 0);
	}

	/**
	 * Optimisticlock exception
	 */
	@Test(expected = OptimisticLockException.class)
	public void testOptimisticLock() {
		EntityTransaction t1 = null, t2 = null;
		try {
			Order order1 = orderDAO.byId(1L);
			orderDAO.getEntityManager().clear();
			Order order2 = orderDAO.byId(1L);
			orderDAO.getEntityManager().clear();

			t1 = orderDAO.getEntityManager().getTransaction();
			t1.begin();
			order1.setStatus(Status.IN_PROGRESS);
			orderDAO.update(order1);
			t1.commit();

			t2 = orderDAO.getEntityManager().getTransaction();
			t2.begin();
			order2.setStatus(Status.IN_PROGRESS);
			orderDAO.update(order2);
			t2.commit();
		} catch (Exception e) {
			t1.rollback();
			throw e;
		}
	}
}
