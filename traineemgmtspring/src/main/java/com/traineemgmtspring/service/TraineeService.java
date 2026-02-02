package com.traineemgmtspring.service;

import com.traineemgmtspring.dto.TraineeDto;

public interface TraineeService {
	public void addTrainee(TraineeDto traineeDto);
	public TraineeDto findTraineeById(int traineeId);
}
