package com.example.CRUD.Error;

import com.example.CRUD.Dto.ErrorResponseDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handlerGenericException(
            Exception e

    ) {

        var errorDto = new ErrorResponseDto(
                "Internal server error",
                e.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorDto);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handlerEntityNotFound(
            EntityNotFoundException e

    ) {


        var errorDto = new ErrorResponseDto(
                "Entity not found",
                e.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorDto);
    }
}