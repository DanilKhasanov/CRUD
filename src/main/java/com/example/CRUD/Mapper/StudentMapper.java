package com.example.CRUD.Mapper;

import com.example.CRUD.Dto.StudentResponseDto;
import com.example.CRUD.Entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentResponseDto toDto(Student student) {
        return new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getGroup().getId(),
                student.getGroup().getName(),
                student.getGroup().getFaculty().getId(),
                student.getGroup().getFaculty().getName()
        );
    }
}