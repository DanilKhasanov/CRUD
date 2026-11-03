package com.example.CRUD.Dto;

import java.time.LocalDateTime;

public record ErrorResponseDto(

        String message,
        String error,
        LocalDateTime errorTime

) {

}