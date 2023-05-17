package com.elsad.demojpaapp.service;

import com.elsad.demojpaapp.model.dto.CourseDTO;
import com.elsad.demojpaapp.model.dto.ReviewDTO;

public interface ReviewService {

    void add(Integer courseId, ReviewDTO reviewDTO);

}
