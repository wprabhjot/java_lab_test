package com.traineemgmtspring.dao;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import com.traineemgmtspring.dto.Trainee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@ConditionalOnProperty(name = "trainee.dao.type", havingValue = "jpa")

public class TraineeJpaDAO implements TraineeDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	public TraineeJpaDAO(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}

	@Override
	public void addTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		em.persist(trainee);
	}

	@Override
	public Trainee findTraineeById(int traineeId) {
		// TODO Auto-generated method stub
		Trainee trainee = em.find(Trainee.class, traineeId);
		return trainee;
	}
}
