package com.nikita.exceptions;

public class InvalidRangeException extends RuntimeException {
    public InvalidRangeException() {
        super("Value isn\'t in acceptable range");
    }

    public InvalidRangeException(String msg) {
        super(msg);
    }
}
