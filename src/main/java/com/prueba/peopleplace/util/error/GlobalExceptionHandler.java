package com.prueba.peopleplace.util.error;

import com.prueba.peopleplace.util.error.exception.ConflictException;
import com.prueba.peopleplace.util.error.exception.PersonNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerPersonNotFoundException(PersonNotFoundException ex, WebRequest request) {
        ErrorResponse errorDetails = new ErrorResponse(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handlerBadRequestException(BadRequestException ex, WebRequest request) {
        ErrorResponse errorDetails = new ErrorResponse(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        ErrorResponse errorDetails = new ErrorResponse(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponse> handlerConflictException(ConflictException ex, WebRequest request) {
        ErrorResponse errorDetails = new ErrorResponse(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse>  handlerGlobalException(Exception ex, WebRequest request) {
        ErrorResponse errorDetails = new ErrorResponse(ex.getMessage(), request.getDescription(false));
        System.out.println("Error: " + ex.getClass());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}