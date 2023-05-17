package com.elsad.demojpaapp.repository;

import com.elsad.demojpaapp.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
