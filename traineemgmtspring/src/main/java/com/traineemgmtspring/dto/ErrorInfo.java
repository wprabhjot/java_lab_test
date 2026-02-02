package com.traineemgmtspring.dto;

import java.time.LocalDateTime;

public class ErrorInfo {

	private String errorMessage;
	private String statusCode;
	private String toContact;
	private LocalDateTime timeStamp;

	public ErrorInfo() {
	}

	public ErrorInfo(String errorMessage, String statusCode, String toContact, LocalDateTime timeStamp) {
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
		this.toContact = toContact;
		this.timeStamp = timeStamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getToContact() {
		return toContact;
	}

	public void setToContact(String toContact) {
		this.toContact = toContact;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
}