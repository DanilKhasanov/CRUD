package com.example.CRUD.Controller;

import com.example.CRUD.Dto.StudentCreateDto;
import com.example.CRUD.Dto.StudentResponseDto;
import com.example.CRUD.Entity.Student;
import com.example.CRUD.Repository.StudentRepository;
import com.example.CRUD.Service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

private final StudentService studentService;

    @GetMapping("")
    ResponseEntity<List<StudentResponseDto>> getStudents(){
        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping("/{id}")
   ResponseEntity<StudentResponseDto> getStudentById(@PathVariable("id") Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping("")
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody StudentCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.createStudent(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(@PathVariable("id") Long id,  @RequestBody StudentCreateDto dto){
        return ResponseEntity.ok(studentService.updateStudentById(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
