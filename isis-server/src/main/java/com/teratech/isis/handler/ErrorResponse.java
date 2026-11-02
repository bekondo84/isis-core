package com.teratech.isis.handler;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ErrorResponse implements Serializable {
    private int status;
    private LocalDateTime date;
    private String message;
    private String erroCode;

    public ErrorResponse() {
    }

    public int getStatus() {
        return status;
    }

    public ErrorResponse setStatus(int status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public ErrorResponse setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getErroCode() {
        return erroCode;
    }

    public ErrorResponse setErroCode(String erroCode) {
        this.erroCode = erroCode;
        return this;
    }
}
