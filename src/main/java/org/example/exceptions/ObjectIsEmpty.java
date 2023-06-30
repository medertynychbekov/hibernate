package org.example.exceptions;

public class ObjectIsEmpty extends RuntimeException{
    public ObjectIsEmpty() {
    }

    public ObjectIsEmpty(String message) {
        super(message);
    }
}
