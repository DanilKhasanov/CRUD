package com.example.CRUD.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentResponseDto {

    private Long id;
    private String name;
    private String email;

    private Long groupId;
    private String groupName;

    private Long facultyId;
    private String facultyName;
}