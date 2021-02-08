package com.ifsp.prss6.schedule.exception.handler;

import com.ifsp.prss6.schedule.exception.BadRequestException;
import com.ifsp.prss6.schedule.exception.PreconditionException;
import com.ifsp.prss6.schedule.exception.detail.ExceptionDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

/**
 * @author vinicius.montouro
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDetails> handlerBadRequestException(BadRequestException e){
        return new ResponseEntity<>(
          ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Bad Request Exception, Check the Documentation")
                .details(e.getMessage())
                .developerMessage(e.getClass().getName())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PreconditionException.class)
    public ResponseEntity<ExceptionDetails> handlerBadRequestException(PreconditionException e){
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.PRECONDITION_FAILED.value())
                        .title("Precondition Request Exception, Check the Documentation")
                        .details(e.getMessage())
                        .developerMessage(e.getClass().getName())
                        .build(), HttpStatus.PRECONDITION_FAILED);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request){
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                        .status(HttpStatus.PRECONDITION_FAILED.value())
                        .title("Precondition Request Exception, Check the Documentation")
                        .details(exception.getMessage())
                        .developerMessage(exception.getClass().getName())
                        .build(), HttpStatus.PRECONDITION_FAILED);
    }

}
