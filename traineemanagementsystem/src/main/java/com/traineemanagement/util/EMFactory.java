package com.traineemanagement.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMFactory {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("traineemanagementPU");

	 public static EntityManager getEntityManager() {
	        return emf.createEntityManager();
	 }
}
