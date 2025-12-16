package com.patient.Controller;

import com.patient.Exception.PatientException;
import com.patient.Exception.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(PatientException.class)
    public ResponseEntity<ErrorInfo> handlePatientException(PatientException e){
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setStatusCode(400);
        errorInfo.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorInfo> handleIllegalArgumentException(IllegalArgumentException e){
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setStatusCode(400);
        errorInfo.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorInfo> handleNullException(NullPointerException ex){
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setDateTime(LocalDateTime.now());
        errorInfo.setMessage(ex.getMessage());
        errorInfo.setStatusCode(500);
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}