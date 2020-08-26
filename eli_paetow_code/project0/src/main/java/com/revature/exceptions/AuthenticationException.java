package com.revature.exceptions;

public class AuthenticationException extends RuntimeException {

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException() {
        super("user authentication has failed");
    }
}
