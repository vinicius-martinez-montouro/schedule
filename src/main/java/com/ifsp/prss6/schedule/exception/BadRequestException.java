package com.ifsp.prss6.schedule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author vinicius.montouro
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RestErrorException{
    public BadRequestException(String message){
        super(message);
    }
}
