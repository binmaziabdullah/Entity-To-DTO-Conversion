package com.example.entitytodto.EntityToDTOConversion.controller;

import com.example.entitytodto.EntityToDTOConversion.dto.StudentDto;
import com.example.entitytodto.EntityToDTOConversion.model.Student;
import com.example.entitytodto.EntityToDTOConversion.services.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/student")
public class StudentController {


    private final StudentService studentService;

    private final ModelMapper modelMapper;

    public StudentController(StudentService studentService, ModelMapper modelMapper) {
        this.studentService = studentService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public StudentDto save(@RequestBody StudentDto studentDto){
        Student student = modelMapper.map(studentDto, Student.class);
        Student s = studentService.addStudent(student);

        StudentDto studentDto1 = modelMapper.map(student, StudentDto.class);

        return studentDto1;
    }
}
