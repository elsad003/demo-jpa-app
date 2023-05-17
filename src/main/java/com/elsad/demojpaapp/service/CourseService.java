package com.elsad.demojpaapp.service;

import com.elsad.demojpaapp.model.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    List<CourseDTO> findAll();

    CourseDTO findById(Integer id);

    CourseDTO save(CourseDTO courseDTO);

    CourseDTO update(Integer id ,CourseDTO courseDTO);

    void deleteById(Integer id);



}
