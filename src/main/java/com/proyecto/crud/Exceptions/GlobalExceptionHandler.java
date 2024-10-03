package com.proyecto.crud.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.RestClientException;

@ControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<String> restClientEx(RestClientException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error al consumir la api" + e.getMessage());
    }

    public ResponseEntity<String> exceptionOccurida(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("exception insesperada" + ex.getMessage());
    }

}
