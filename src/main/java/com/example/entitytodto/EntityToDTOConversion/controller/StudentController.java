package com.example.entitytodto.EntityToDTOConversion.controller;

import com.example.entitytodto.EntityToDTOConversion.dto.StudentDto;
import com.example.entitytodto.EntityToDTOConversion.model.PropertyNotFoundException;
import com.example.entitytodto.EntityToDTOConversion.model.Student;
import com.example.entitytodto.EntityToDTOConversion.services.StudentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public StudentDto save(@RequestBody StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        Student s = studentService.addStudent(student);

        return modelMapper.map(student, StudentDto.class);
    }

    @GetMapping
    public List<StudentDto> getStudents() {

        return studentService.getStudents()
              .stream()
              .map(student -> modelMapper.map(student, StudentDto.class))
              .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        return ResponseEntity.ok(studentDto);
    }

    @PutMapping
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);

        student = studentService.updateStudent(student);

        StudentDto studentDto1 = modelMapper.map(student, StudentDto.class);

        return ResponseEntity.ok(studentDto1);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.deleteStudent(id));
    }

}
