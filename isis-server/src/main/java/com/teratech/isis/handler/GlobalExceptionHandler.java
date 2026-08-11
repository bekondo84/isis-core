package com.teratech.isis.handler;


import com.teratech.exceptions.ApplicationException;
import io.jsonwebtoken.ExpiredJwtException;
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

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException e, WebRequest request) {

        ErrorResponse error = new ErrorResponse().setDate(LocalDateTime.now())
                .setMessage(e.getMessage())
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .setErroCode(ApplicationException.class.getName());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
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
