package com.ifsp.prss6.schedule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author vinicius.montouro
 */
@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class PreconditionException extends RestErrorException{
    public PreconditionException(String message){
        super(message);
    }
}
