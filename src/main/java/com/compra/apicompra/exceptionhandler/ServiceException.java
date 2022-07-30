package com.compra.apicompra.exceptionhandler;

public class ServiceException extends RuntimeException {


    public ServiceException(String message) {
    }

    public String ServiceException(String message){
        return message;
    }

}
