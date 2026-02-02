package com.traineemgmtspring.util;

import com.traineemgmtspring.dto.TraineeDto;
import com.traineemgmtspring.entities.Trainee;

public class TraineeConverter {

	public static TraineeDto convertToDto(Trainee trainee) {
        if (trainee == null) {
            return null;
        }

        return TraineeDto.builder()
                .id(trainee.getId())
                .trainee_name(trainee.getTrainee_name())
                .branch(trainee.getBranch())
                .percentage(trainee.getPercentage())
                .build();
    }

	public static Trainee convertToEntity(TraineeDto traineeDto) {
        if (traineeDto == null) {
            return null;
        }

        return Trainee.builder()
                .id(traineeDto.getId())
                .trainee_name(traineeDto.getTrainee_name())
                .branch(traineeDto.getBranch())
                .percentage(traineeDto.getPercentage())
                .build();
    }
}