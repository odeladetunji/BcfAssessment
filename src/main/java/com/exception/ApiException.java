package com.exception;

import lombok.Data;

@Data
public class ApiException extends RuntimeException {

    private String message;

    public ApiException(String message){
        super();
        this.message = message;
    }
}
