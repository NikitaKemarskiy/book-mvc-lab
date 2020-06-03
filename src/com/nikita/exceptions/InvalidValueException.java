package com.nikita.exceptions;

public class InvalidValueException extends RuntimeException {
    public InvalidValueException() {
        super("Invalid value");
    }

    public InvalidValueException(String msg) {
        super(msg);
    }
}
