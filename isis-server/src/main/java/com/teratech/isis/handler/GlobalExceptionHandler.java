package com.teratech.isis.handler;


import com.teratech.exceptions.ApplicationException;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException e, WebRequest request) {

        ErrorResponse error = new ErrorResponse().setDate(LocalDateTime.now())
                .setMessage(e.getMessage())
                .setStatus(getHttpStatus(e))
                .setErroCode(ApplicationException.class.getName());

        //LOG.info(e.get);
        return new ResponseEntity<>(error, getHttpStatus(e));
    }

    private static HttpStatus getHttpStatus(ApplicationException e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (e.getCode().equals("404")) {
            status = HttpStatus.NOT_FOUND;
        }
        return status;
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Object> handleExpiredJwtException(ExpiredJwtException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now().toString());
        body.put("status", HttpStatus.UNAUTHORIZED.value());
        body.put("error", "Unauthorized");
        body.put("message", "Le jeton de connexion (JWT) a expiré. Veuillez vous reconnecter.");
        body.put("path", "Erreur d'authentification");

        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }
}
