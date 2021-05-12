package com.example.entitytodto.EntityToDTOConversion.controller;

import com.example.entitytodto.EntityToDTOConversion.dto.StudentDto;
import com.example.entitytodto.EntityToDTOConversion.model.Student;
import com.example.entitytodto.EntityToDTOConversion.repository.StudentRepository;
import com.example.entitytodto.EntityToDTOConversion.services.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/student")
public class StudentController {


    private final StudentService studentService;
    private final StudentRepository studentRepository;

    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public StudentDto save(@RequestBody StudentDto studentDto){
        Student student = studentService.mapDtoToEntity(studentDto);
        student = studentRepository.save(student);
        return studentService.mapEntityToDto(student);
    }

}
