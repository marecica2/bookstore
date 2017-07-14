package org.bmsource.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateless
public class AbstractDAO {

	@PersistenceContext(unitName = "bookstoreDS", type = PersistenceContextType.TRANSACTION)
	protected EntityManager entityManager;

}
