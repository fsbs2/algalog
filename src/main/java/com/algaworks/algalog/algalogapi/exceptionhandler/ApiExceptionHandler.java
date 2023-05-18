package com.algaworks.algalog.algalogapi.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
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
}
