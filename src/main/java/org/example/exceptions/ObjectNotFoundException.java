package org.example.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException() {
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
