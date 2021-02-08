package com.ifsp.prss6.schedule.exception;

import org.springframework.http.HttpStatus;

/**
 * @author vinicius.montouro
 */
public class RestErrorException extends RuntimeException {
    private HttpStatus status;

    public RestErrorException(HttpStatus status){
        this.status = status;
    }

    public RestErrorException(String message){
        super(message);
    }

    public RestErrorException(HttpStatus status, String message){
        super(message);
        this.status = status;
    }
}
