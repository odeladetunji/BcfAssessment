package com.exception;

import lombok.Data;

@Data
public class AuthenticationError extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public AuthenticationError(String msg){
        super(msg);
    }
}
