package com.traineemgmtspring.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="trainee")
public class Trainee {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "trainee_id")
    private int id;
    private String trainee_name;
    private String branch;
    private double percentage;
	
	public Trainee(String trainee_name, String branch, double percentage) {
		this.trainee_name = trainee_name;
		this.branch = branch;
		this.percentage = percentage;
	}
	
}
