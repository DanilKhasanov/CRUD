package com.example.CRUD.Dto;

import lombok.Data;

@Data
public class StudentCreateDto {
    private String name;
    private String email;
    private Long groupId;
}