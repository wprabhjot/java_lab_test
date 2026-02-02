package com.traineemgmtspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traineemgmtspring.dto.TraineeDto;
import com.traineemgmtspring.service.TraineeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "v1")
public class TraineeController {

    private final TraineeService traineeService;

    @GetMapping(path = "trainees/{id}")
    public ResponseEntity<TraineeDto> getById(@PathVariable int id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(traineeService.findTraineeById(id));
    }

    @PostMapping(path = "trainees")
    public ResponseEntity<Void> addTrainee( @RequestBody TraineeDto traineeDto) {
        traineeService.addTrainee(traineeDto);
        return ResponseEntity
                .status(HttpStatus.CREATED).build();
    }
}
