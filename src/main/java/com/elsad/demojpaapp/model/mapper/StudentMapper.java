package com.elsad.demojpaapp.model.mapper;

import com.elsad.demojpaapp.model.dto.StudentDTO;
import com.elsad.demojpaapp.model.entity.Student;


public interface StudentMapper {

    StudentDTO toDto(Student student);

    Student toEntity(StudentDTO studentDTO);
}
