package com.example.entitytodto.EntityToDTOConversion.repository;

import com.example.entitytodto.EntityToDTOConversion.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
