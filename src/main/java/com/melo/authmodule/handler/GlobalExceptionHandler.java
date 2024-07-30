package com.melo.authmodule.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ErrorHandler errorHandler;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        // Hata işleme kodları buraya gelecek
        errorHandler.logError(e);
        return new ResponseEntity<>("Bir hata oluştu", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

