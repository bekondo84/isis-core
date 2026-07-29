package com.teratech.isis.handler;


import com.teratech.exceptions.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException e, WebRequest request) {

        ErrorResponse error = new ErrorResponse().setDate(LocalDateTime.now())
                .setMessage(e.getMessage())
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .setErroCode(ApplicationException.class.getName());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
