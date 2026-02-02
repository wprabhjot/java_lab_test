package com.traineemgmtspring.service;

import org.springframework.stereotype.Service;

import com.traineemgmtspring.dao.TraineeDAO;
import com.traineemgmtspring.dto.TraineeDto;
import com.traineemgmtspring.entities.Trainee;
import com.traineemgmtspring.exceptions.TraineeDataAccessException;
import com.traineemgmtspring.util.TraineeConverter;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class TraineeServiceImpl implements TraineeService{
    private TraineeDAO traineeDao;
    
    public TraineeServiceImpl(TraineeDAO traineeDao) {
        this.traineeDao = traineeDao;
    }
    private void validatetrainee(TraineeDto trainee) {
    	if(trainee==null) throw new TraineeDataAccessException("trainee cannot be null");
    	if (trainee.getTrainee_name() == null || trainee.getTrainee_name().trim().isEmpty()) throw new TraineeDataAccessException("Trainee name cannot be empty");
    	if (trainee.getBranch() == null || trainee.getBranch().trim().isEmpty()) throw new TraineeDataAccessException("Branch cannot be empty");
    	if(trainee.getPercentage()<0) throw new TraineeDataAccessException("Price can't be less than zero");
    }
    
    @Override
    public void addTrainee(TraineeDto traineeDto) throws TraineeDataAccessException {
    	    validatetrainee(traineeDto);
    	    Trainee traineeEntity =
    	            TraineeConverter.convertToEntity(traineeDto);

    	    traineeDao.addTrainee(traineeEntity);
    	
    }
    
    @Override
    public TraineeDto findTraineeById(int traineeId) {
        if (traineeId <= 0) {
            throw new TraineeDataAccessException("Invalid trainee ID");
        }

        Trainee traineeEntity = traineeDao.findTraineeById(traineeId);

        if (traineeEntity == null) {
            throw new TraineeDataAccessException("Trainee not found");
        }

        return TraineeConverter.convertToDto(traineeEntity);
    }

    

}