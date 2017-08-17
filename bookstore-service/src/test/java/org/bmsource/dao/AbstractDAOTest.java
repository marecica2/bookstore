package org.bmsource.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class AbstractDAOTest {

	private static EntityManagerFactory emf;
	static EntityManager entityManager;

	/**
	 * Extended @BeforeClass will be called after this superclass, but method
	 * must be of different name
	 */
	@BeforeClass
	public static void AbstractDAOTestInitTestFixture() throws Exception {
		emf = Persistence.createEntityManagerFactory("bookstoreTestDS");
		entityManager = emf.createEntityManager();
	}

	/**
	 * Extended @AfterClass will be called before this superclass, but method
	 * must be of different name
	 */
	@AfterClass
	public static void AbstractDAOTestTearDown() {
		entityManager.clear();
		entityManager.close();
		emf.close();
	}
}
