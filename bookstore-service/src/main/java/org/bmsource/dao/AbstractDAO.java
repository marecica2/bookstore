package org.bmsource.dao;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

}
