package com.traineemgmtspring.service;

import com.traineemgmtspring.dto.Trainee;

public interface TraineeService {
	public void addTrainee(Trainee trainee);
	public Trainee findTraineeById(int traineeId);
}
