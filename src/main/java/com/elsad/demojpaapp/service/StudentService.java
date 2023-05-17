package com.elsad.demojpaapp.service;

import com.elsad.demojpaapp.model.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> findAll();

    StudentDTO findById(Integer id);

    StudentDTO save(StudentDTO courseDTO);

    StudentDTO update(Integer id, StudentDTO courseDTO);

    void deleteById(Integer id);

    void buyCourse(Integer StudentId,Integer courseId);
}
