package com.traineemgmtspring.service;

import org.springframework.stereotype.Service;

import com.traineemgmtspring.dao.TraineeDAO;
import com.traineemgmtspring.dto.Trainee;
import com.traineemgmtspring.exceptions.TraineeDataAccessException;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class TraineeServiceImpl implements TraineeService{
    private TraineeDAO traineeDao;
    
    public TraineeServiceImpl(TraineeDAO traineeDao) {
        this.traineeDao = traineeDao;
    }
    private void validatetrainee(Trainee trainee) {
    	if(trainee==null) throw new TraineeDataAccessException("trainee cannot be null");
    	if (trainee.getTrainee_name() == null || trainee.getTrainee_name().trim().isEmpty()) throw new TraineeDataAccessException("Trainee name cannot be empty");
    	if (trainee.getBranch() == null || trainee.getBranch().trim().isEmpty()) throw new TraineeDataAccessException("Branch cannot be empty");
    	if(trainee.getPercentage()<0) throw new TraineeDataAccessException("Price can't be less than zero");
    }
    
    @Override
    public void addTrainee(Trainee trainee) throws TraineeDataAccessException {
			validatetrainee(trainee);
			traineeDao.addTrainee(trainee);
    }
    
    @Override
    public Trainee findTraineeById(int traineeId) throws TraineeDataAccessException {
    	if(traineeId<=0) {
    		throw new TraineeDataAccessException("Invalid trainee ID");
    	}
    	Trainee trainee =  traineeDao.findTraineeById(traineeId);	
    	if(trainee==null) {
    		throw new TraineeDataAccessException("Invalid trainee ID: "+ traineeId);
    	}
    	validatetrainee(trainee);
		return trainee;
    }
    

}