package com.example.CRUD.Service;

import com.example.CRUD.Dto.StudentCreateDto;
import com.example.CRUD.Dto.StudentResponseDto;
import com.example.CRUD.Entity.Group;
import com.example.CRUD.Entity.Student;
import com.example.CRUD.Mapper.StudentMapper;
import com.example.CRUD.Repository.GroupRepository;
import com.example.CRUD.Repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;


@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final StudentMapper studentMapper;

    public List<StudentResponseDto> getStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDto)
                .toList();
    }

    public StudentResponseDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Student with id " + id + " not found"
                        )
                );

        return studentMapper.toDto(student);
    }


    public StudentResponseDto createStudent(StudentCreateDto dto) {

        Group group = groupRepository.findById(dto.getGroupId())
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Group with id " + dto.getGroupId() + " not found"
                        )
                );

        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setGroup(group);

        Student savedStudent = studentRepository.save(student);

        return studentMapper.toDto(savedStudent);

    }

    public StudentResponseDto updateStudentById(Long id, StudentCreateDto dto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Student with id " + id + " not found"
                        )
                );

        Group group = groupRepository.findById(dto.getGroupId())
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Group with id " + dto.getGroupId() + " not found"
                        )
                );
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setGroup(group);

        Student savedStudent = studentRepository.save(student);

        return studentMapper.toDto(savedStudent);

    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Student with id " + id + " not found"
                        )
                );
        studentRepository.delete(student);
    }
}
