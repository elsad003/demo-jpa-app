package com.elsad.demojpaapp.repository;

import com.elsad.demojpaapp.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
