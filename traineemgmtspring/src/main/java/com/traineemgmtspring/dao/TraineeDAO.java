package com.traineemgmtspring.dao;

import com.traineemgmtspring.entities.Trainee;

public interface TraineeDAO {
	
	public void addTrainee(Trainee trainee);

    public Trainee findTraineeById(int traineeId);
}
