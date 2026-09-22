package com.miguelsouza.API_REST.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id) {
        super("Resource not found. id " + id);
    }
}
