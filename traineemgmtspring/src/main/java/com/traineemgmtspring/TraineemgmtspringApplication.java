package com.traineemgmtspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.traineemgmtspring.controller.TraineeController;
import com.traineemgmtspring.dto.TraineeDto;

@SpringBootApplication
public class TraineemgmtspringApplication implements CommandLineRunner {


	@Autowired
	private TraineeController traineeController;

    TraineemgmtspringApplication(TraineeController traineeController) {
        this.traineeController = traineeController;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(TraineemgmtspringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		traineeController.addTrainee(Trainee.builder().trainee_name("raj").branch("xyz").percentage(67).build());
	}

}
