package com.example.snehithModule.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    Long id;
    String field;
    String fieldName;
    String resourceName;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String resourceName,String field,String fieldName) {
        super(String.format("%s not found with %s: %s",resourceName,field,fieldName));
        this.fieldName = fieldName;
        this.field = field;
        this.resourceName = resourceName;
    }

    public ResourceNotFoundException(String resourceName,String  field,Long id) {
        super(String.format("%s not found with %s: %d",resourceName,field,id));
        this.id = id;
        this.field = field;
        this.resourceName = resourceName;
    }
}
