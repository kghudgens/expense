package com.expense.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    private int statusCode;

    private String status;

    private String message;

    private String stackTrace;

    private Object data;

    public ErrorResponse() {
        timestamp = new Date();
    }

    public ErrorResponse(HttpStatus httpStatus, String message, String stackTrace, Object data) {
        this.statusCode = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
        this.stackTrace = stackTrace;
        this.data = data;
    }

    public ErrorResponse(HttpStatus httpStatus, String message, String stackTrace) {
        this.statusCode = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
        this.stackTrace = stackTrace;
    }

    public ErrorResponse(HttpStatus httpStatus, String message) {
        this.statusCode = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStackTrace() {
        return this.stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
