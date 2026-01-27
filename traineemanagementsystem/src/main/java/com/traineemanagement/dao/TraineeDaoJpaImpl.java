package com.traineemanagement.dao;

import com.traineemanagement.dto.Trainee;
import com.traineemanagement.exceptions.DaoException;
import com.traineemanagement.util.EMFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class TraineeDaoJpaImpl implements TraineeDao {

	@Override
	public void addTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		EntityManager em = EMFactory.getEntityManager();
      EntityTransaction tx = em.getTransaction();

      try {
          tx.begin();
          em.persist(trainee);
          tx.commit();
      } catch (PersistenceException e) {
      	if (tx.isActive()) tx.rollback();
          throw new DaoException("Failed to add trainee: " + trainee.getTrainee_name(), e);
      } finally {
          em.close();
      }
	}

	@Override
	public Trainee findTraineeById(int traineeId) {
		// TODO Auto-generated method stub
		EntityManager em = EMFactory.getEntityManager();
		try {
			Trainee trainee = em.find(Trainee.class, traineeId);
			if(trainee==null) {
				throw new DaoException("No trainee found with id " + traineeId, null);
			}
			return trainee;
		} catch (PersistenceException e) {
			// TODO: handle exception
			 throw new DaoException("Failed to fetch trainee with id " + traineeId, e);
		} finally {
			em.close();
		}
	}

   

}
