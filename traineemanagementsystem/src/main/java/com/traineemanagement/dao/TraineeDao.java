package com.traineemanagement.dao;

import com.traineemanagement.dto.Trainee;

public interface TraineeDao {

	public void addTrainee(Trainee trainee);

    public Trainee findTraineeById(int traineeId);
}