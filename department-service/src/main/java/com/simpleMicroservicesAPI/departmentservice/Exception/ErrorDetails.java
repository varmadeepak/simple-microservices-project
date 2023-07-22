package com.simpleMicroservicesAPI.departmentservice.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


public class ErrorDetails {

    private LocalDateTime timestamp;
    private String errorMessage;
    private String errorCode;
    private String path;

    public ErrorDetails(LocalDateTime timestamp , String errorMessage , String errorCode,
                        String path){
        this.timestamp = timestamp;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.path=path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
