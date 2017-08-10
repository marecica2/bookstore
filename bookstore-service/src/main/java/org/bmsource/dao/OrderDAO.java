package org.bmsource.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.Stateless;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.bmsource.bookstore.model.entity.Book;
import org.bmsource.bookstore.model.entity.Order;
import org.bmsource.bookstore.model.entity.OrderProduct;
import org.bmsource.bookstore.model.entity.OrderProduct_;
import org.bmsource.bookstore.model.entity.Order_;
import org.bmsource.bookstore.model.entity.Product;
import org.bmsource.bookstore.model.entity.Product_;

@Stateless
public class OrderDAO extends AbstractDAO<Order> {

	public OrderDAO() {
		super();
		setType(Order.class);
	}

	public Collection<Order> findAllQuery() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Order> cq = cb.createQuery(Order.class);
		Root<Order> root = cq.from(Order.class);
		CriteriaQuery<Order> all = cq.select(root);

		return entityManager.createQuery(all).getResultList();
	}

	/**
	 * Join Where example
	 * 
	 * @param book
	 * @return
	 */
	public Collection<Order> findForBook(Book book) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Order> cq = cb.createQuery(Order.class);
		Root<Order> root = cq.from(Order.class);
		Join<OrderProduct, Product> join = root.join(Order_.orderProducts).join(OrderProduct_.product);
		cq.select(root).where(cb.equal(join.get(Product_.name), book.getName()));

		TypedQuery<Order> typedQuery = entityManager.createQuery(cq);
		List<Order> orders = typedQuery.getResultList();
		printQuery(typedQuery);
		return orders;
	}

	/**
	 * Fetch join where example
	 * 
	 * @param book
	 * @return
	 */
	public Order byIdFetch(Long id) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Order> cq = cb.createQuery(Order.class);
		Root<Order> root = cq.from(Order.class);
		root.fetch(Order_.orderProducts);
		cq.select(root).where(cb.equal(root.get(Order_.id), id));
		TypedQuery<Order> typedQuery = entityManager.createQuery(cq);
		return typedQuery.getSingleResult();
	}

	/**
	 * Tuple example
	 */
	public List<Tuple> findAllOrdersWithProducts() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> query = cb.createQuery(Tuple.class);
		Root<Order> r1 = query.from(Order.class);
		Join<OrderProduct, Product> join = r1.join(Order_.orderProducts, JoinType.LEFT).join(OrderProduct_.product,
				JoinType.LEFT);
		query.select(cb.tuple(r1, join))
				.where(cb.greaterThan(join.get(Product_.createdDate),
						new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(20))));
		TypedQuery<Tuple> q = entityManager.createQuery(query);
		return q.getResultList();
	}

	/**
	 * SQLResultSetMapping example
	 * 
	 * @return
	 */
	public List<Object[]> namedNativeQueryResultsetMapping() {
		List<Object[]> resultList = entityManager.createNamedQuery(Order.NAMED_QUERY)
				.getResultList();
		return resultList;
	}
}
