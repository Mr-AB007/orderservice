package com.microservice.orderservice.exception;

import com.microservice.orderservice.payload.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PaymentServiceGlobalExceptionHandler {

    @ExceptionHandler(OrderServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(OrderServiceCustomException exception) {

//        ErrorResponse errorResponse =new ErrorResponse();
//        errorResponse.setErrorMessage(exception.getMessage());
//        errorResponse.setErrorCode(exception.getErrorCode());
//
//        return ResponseEntity.status(exception.getStatus()).body(errorResponse);

        //using builder pattern

        return ResponseEntity.status(exception.getStatus()).body(ErrorResponse.builder()
                .errorMessage(exception.getMessage())
                .errorCode(exception.getErrorCode())
                .build());
    }
}
