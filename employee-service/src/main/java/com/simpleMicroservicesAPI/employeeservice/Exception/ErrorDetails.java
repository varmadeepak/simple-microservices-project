package com.simpleMicroservicesAPI.employeeservice.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



public class ErrorDetails {
    private LocalDateTime timeStamp;
    private String errorCode;
    private String errorMessage;
    private String errorPath;

    public ErrorDetails(LocalDateTime timeStamp, String errorCode, String errorMessage, String errorPath) {
        this.timeStamp = timeStamp;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorPath = errorPath;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorPath() {
        return errorPath;
    }

    public void setErrorPath(String errorPath) {
        this.errorPath = errorPath;
    }
}
