package org.bmsource.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.bmsource.bookstore.model.entity.Order;

@Stateless
public class AbstractDAO<T> {

	@PersistenceContext(unitName = "bookstoreDS", type = PersistenceContextType.TRANSACTION)
	protected EntityManager entityManager;

	private Class<T> type;

	void setType(Class<T> type) {
		this.type = type;
	}

	public T byId(Long id) {
		return entityManager.find(type, id);
	}

	public Order byId(Long id, String fetchGraph) {
		EntityGraph<?> graph = entityManager.getEntityGraph(fetchGraph);
		Map<String, Object> hints = new HashMap<>();
		hints.put("javax.persistence.fetchgraph", graph);

		return entityManager.find(Order.class, id, hints);
	}

	public T create(T entity) {
		entityManager.persist(entity);
		entityManager.flush();
		return entity;
	}

	public T update(T entity) {
		entityManager.merge(entity);
		entityManager.flush();
		return entity;
	}

	public Collection<T> findAll() {
		CriteriaQuery<T> cq = entityManager.getCriteriaBuilder().createQuery(type);
		Root<T> rootEntry = cq.from(type);

		CriteriaQuery<T> all = cq.select(rootEntry);
		TypedQuery<T> allQuery = entityManager.createQuery(all);

		List<T> items = allQuery.getResultList();
		return items;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	protected void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	/**
	 * Not needed when hibernate.use_sql_comments=true
	 * 
	 * @param typedQuery
	 */
	void printQuery(TypedQuery<?> typedQuery) {
		System.err.println("QUERY : " + typedQuery.unwrap(org.hibernate.Query.class).getQueryString());
	}

}
