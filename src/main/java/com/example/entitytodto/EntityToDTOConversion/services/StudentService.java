package com.example.entitytodto.EntityToDTOConversion.services;


import com.example.entitytodto.EntityToDTOConversion.model.PropertyNotFoundException;
import com.example.entitytodto.EntityToDTOConversion.model.Student;
import com.example.entitytodto.EntityToDTOConversion.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


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

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(() -> new PropertyNotFoundException("Student not found"));
    }

    public Student updateStudent(Student student){
        if (student.getId()!=null){
            Optional<Student> optionalStudent = studentRepository.findById(student.getId());
            if (!optionalStudent.isPresent()){
                    throw new PropertyNotFoundException("Student not found");
            }
        }
        return studentRepository.save(student);

    }

    public Student deleteStudent(Long id){
      Student student = studentRepository.findById(id).orElseThrow(() -> new PropertyNotFoundException("Student not found!"));
      studentRepository.deleteById(student.getId());

      return student;
    }
}
