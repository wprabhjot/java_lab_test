package com.traineemgmtspring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TraineeDto {

    private int id;
    private String trainee_name;
    private String branch;
    private double percentage;
	
	public TraineeDto(String trainee_name, String branch, double percentage) {
		this.trainee_name = trainee_name;
		this.branch = branch;
		this.percentage = percentage;
	}
	
}
