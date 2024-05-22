package com.prueba.peopleplace.util.error.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String message) {
        super(message);
    }
}
