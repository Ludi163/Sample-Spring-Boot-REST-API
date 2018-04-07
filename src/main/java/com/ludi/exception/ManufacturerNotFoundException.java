package com.ludi.exception;

public class ManufacturerNotFoundException extends RuntimeException {

    public ManufacturerNotFoundException(String msg){
        super(msg);
    }
}
