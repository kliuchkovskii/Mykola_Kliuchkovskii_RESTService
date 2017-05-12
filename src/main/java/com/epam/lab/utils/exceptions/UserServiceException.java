package com.epam.lab.utils.exceptions;

import javax.ws.rs.core.Response.Status;

public class UserServiceException extends RuntimeException {

    private String message;
    private Status status;

    public UserServiceException(String message){
        this.message = message;
    }

    public UserServiceException(String message, Status status){
        this.message = message;
        this.status = status;
    }

    public UserServiceException(){
    }
}
