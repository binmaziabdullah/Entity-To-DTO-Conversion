package com.example.entitytodto.EntityToDTOConversion.services;


import com.example.entitytodto.EntityToDTOConversion.model.Student;
import com.example.entitytodto.EntityToDTOConversion.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

}
