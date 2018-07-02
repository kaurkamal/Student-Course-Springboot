package com.cdk.assignment4.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by kaurk on 6/27/18.
 */

@ControllerAdvice
public class ExceptionHanlingController {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ExceptionResponse> responseNotFoundEntity(StudentNotFoundException exception ) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("Student Not Found with this id");
        response.setErrorMessage(exception.getMessage());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }

}
