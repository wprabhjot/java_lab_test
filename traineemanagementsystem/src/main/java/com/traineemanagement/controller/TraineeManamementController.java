package com.traineemanagement.controller;


import com.traineemanagement.dao.TraineeDao;
import com.traineemanagement.dao.TraineeDaoJdbcImpl;
import com.traineemanagement.dao.TraineeDaoJpaImpl;
//import com.traineemanagement.dao.TraineeDaoJpaImpl;
import com.traineemanagement.dto.Trainee;
import com.traineemanagement.service.TraineeService;

public class TraineeManamementController {

    public static void main(String[] args) {
        TraineeDao dao = new TraineeDaoJpaImpl();
        TraineeService service = new TraineeService(dao);

        try {

        	Trainee trainee1 = new Trainee("RK", "oracle", 33.75);
            Trainee trainee2 = new Trainee("MK", "java", 57.00);

            service.addTrainee(trainee1);
            service.addTrainee(trainee2);
            
            System.out.println("Trainee added successfully!");

            
            System.out.println("Get Trainee by ID 8:");
            Trainee t = service.findTraineeById(8);
            System.out.println(t);


        } catch (RuntimeException e) {
            System.out.println("Operation failed: " + e.getMessage());
        }
    }
}
