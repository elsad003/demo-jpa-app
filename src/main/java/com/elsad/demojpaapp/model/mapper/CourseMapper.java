package com.elsad.demojpaapp.model.mapper;

import com.elsad.demojpaapp.model.dto.CourseDTO;
import com.elsad.demojpaapp.model.entity.Course;


public interface CourseMapper {

    CourseDTO toDto(Course course);

    Course toEntity(CourseDTO courseDTO);

}
