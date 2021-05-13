package com.example.entitytodto.EntityToDTOConversion.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PropertyNotFoundException extends RuntimeException{

    public PropertyNotFoundException(String msg) {
        super(msg);
    }
}
