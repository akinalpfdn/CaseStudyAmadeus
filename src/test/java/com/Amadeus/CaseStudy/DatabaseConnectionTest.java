package com.Amadeus.CaseStudy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = CaseStudyApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class DatabaseConnectionTest {

	 @Autowired
	    private EntityManager entityManager;

	    @Test
	    public void testDatabaseConnection() {
	        try {
	            // Attempt to perform a simple query or validation
	            entityManager.createNativeQuery("SELECT 1 ").getSingleResult();
	        } catch (PersistenceException e) {
	            throw new AssertionError("Database connection failed.", e);
	        }
	    }
}
