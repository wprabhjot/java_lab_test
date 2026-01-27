package com.traineemanagement.service;

import com.traineemanagement.dao.TraineeDao;
import com.traineemanagement.dto.Trainee;
import com.traineemanagement.exceptions.DaoException;
import com.traineemanagement.exceptions.ServiceException;

public class TraineeService {
    private TraineeDao traineeDao;
    public TraineeService(TraineeDao traineeDao) {
        this.traineeDao = traineeDao;
    }
    private void validatetrainee(Trainee trainee) {
    	if(trainee==null) throw new IllegalArgumentException("trainee cannot be null");
    	if (trainee.getTrainee_name() == null || trainee.getTrainee_name().trim().isEmpty()) throw new IllegalArgumentException("Trainee name cannot be empty");
    	if (trainee.getBranch() == null || trainee.getBranch().trim().isEmpty()) throw new IllegalArgumentException("Branch cannot be empty");
    	if(trainee.getPercentage()<0) throw new IllegalArgumentException("Price can't be less than zero");
    }
    
    public void addTrainee(Trainee trainee) {
    	try {
			validatetrainee(trainee);
			traineeDao.addTrainee(trainee);
		} catch (DaoException e) {
			// TODO: handle exception
			throw new ServiceException("Some issue while adding trainee. Try again later", e);
		}
    }
    
    public Trainee findTraineeById(int traineeId) {
    	if(traineeId<=0) {
    		throw new IllegalArgumentException("Invalid book ID");
    	}
    	try {
			return traineeDao.findTraineeById(traineeId);	
		} catch (DaoException e) {
			// TODO: handle exception
			throw new ServiceException("Some issue while fetching trainee. Try again later", e);
		}
    }
    

}