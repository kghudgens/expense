package com.expense.exceptions;

import org.springframework.http.HttpStatus;

public class NoRecordFoundException extends RuntimeException {

    public NoRecordFoundException() {
        super();
    }

    public NoRecordFoundException(String string) {
        super(string);
    }

    public NoRecordFoundException(String string, HttpStatus noContent) {
    }
}