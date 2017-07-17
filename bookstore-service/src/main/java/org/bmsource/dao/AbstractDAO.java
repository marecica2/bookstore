package org.bmsource.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

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

	public T save(T entity) {
		entityManager.persist(entity);
		entityManager.flush();
		return entity;
	}

}
