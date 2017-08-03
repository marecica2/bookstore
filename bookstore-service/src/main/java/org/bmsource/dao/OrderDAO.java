package org.bmsource.dao;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.bmsource.bookstore.model.entity.Book;
import org.bmsource.bookstore.model.entity.Order;
import org.bmsource.bookstore.model.entity.OrderProduct;
import org.bmsource.bookstore.model.entity.OrderProduct_;
import org.bmsource.bookstore.model.entity.Order_;
import org.bmsource.bookstore.model.entity.Product;
import org.bmsource.bookstore.model.entity.Product_;
import org.hibernate.query.Query;

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

	private void printQuery(TypedQuery<Order> typedQuery) {
		System.err.println("QUERY : " + typedQuery.unwrap(Query.class).getQueryString());
	}
}
