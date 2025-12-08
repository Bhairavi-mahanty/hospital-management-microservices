package com.doctor.Controller;

import com.doctor.Exception.DoctorException;
import com.doctor.Exception.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorInfo> handleException(IllegalArgumentException e){
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setStatusCode(400);
        errorInfo.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorInfo> handleException(NullPointerException e){
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setStatusCode(400);
        errorInfo.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }
}
