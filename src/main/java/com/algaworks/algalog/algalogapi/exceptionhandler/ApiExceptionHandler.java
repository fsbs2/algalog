package com.algaworks.algalog.algalogapi.exceptionhandler;

import com.algaworks.algalog.algalogapi.domain.exception.BusinessException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    private final String errorTitle = "One or more fields in the request are invalids";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<Error.Field> fields = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(
                (error) -> {
                    String name = ((FieldError) error).getField();
                    String message = error.getDefaultMessage();

                    fields.add(new Error.Field(name, message));
                }
        );

        Error error = new Error(status.value(), LocalDateTime.now(), errorTitle, fields);
        return handleExceptionInternal(ex, error, headers, status, request);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException ex,WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        var error = Error.builder()
                .status(status.value())
                .dateHour(LocalDateTime.now())
                .title(ex.getMessage())
                .build();
        return handleExceptionInternal(ex,error,new HttpHeaders(),status,request);
    }
    @ExceptionHandler(UnrecognizedPropertyException.class)
    public ResponseEntity<Object> handleUnrecognizedPropertyException(UnrecognizedPropertyException ex,WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        var error = Error.builder()
                .status(status.value())
                .dateHour(LocalDateTime.now())
                .title(ex.getMessage())
                .build();
        return handleExceptionInternal(ex,error,new HttpHeaders(),status,request);
    }
}
