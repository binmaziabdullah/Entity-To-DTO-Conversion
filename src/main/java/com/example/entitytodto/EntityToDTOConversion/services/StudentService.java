package com.example.entitytodto.EntityToDTOConversion.services;

import com.example.entitytodto.EntityToDTOConversion.dto.StudentDto;
import com.example.entitytodto.EntityToDTOConversion.model.Student;
import com.example.entitytodto.EntityToDTOConversion.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collector;

@Service
@Transactional
public class StudentService {

    public StudentDto mapEntityToDto(Student student){
        StudentDto studentDto = new StudentDto();

        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setSurname(student.getSurname());
        studentDto.setYear(student.getYear());

        return studentDto;
    }

    public Student mapDtoToEntity(StudentDto studentDto){

        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setYear(studentDto.getYear());

        return student;
    }


}
