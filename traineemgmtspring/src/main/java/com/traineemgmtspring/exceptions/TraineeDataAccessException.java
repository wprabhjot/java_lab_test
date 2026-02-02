package com.traineemgmtspring.exceptions;

public class TraineeDataAccessException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public TraineeDataAccessException(String message) {
        super(message);
    }
	public TraineeDataAccessException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
