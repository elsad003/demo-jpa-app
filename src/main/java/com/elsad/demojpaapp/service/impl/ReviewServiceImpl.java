package com.elsad.demojpaapp.service.impl;

import com.elsad.demojpaapp.model.dto.ReviewDTO;
import com.elsad.demojpaapp.model.entity.Course;
import com.elsad.demojpaapp.model.mapper.ReviewMapper;
import com.elsad.demojpaapp.repository.CourseRepository;
import com.elsad.demojpaapp.service.ReviewService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final CourseRepository courseRepository;
    private final ReviewMapper reviewMapper;

    @Override
    @Transactional
    public void add(Integer courseId, ReviewDTO reviewDTO) {

        Optional<Course> byId = courseRepository.findById(courseId);
        if (byId.isEmpty()) {
            throw new RuntimeException("Course by id : " + courseId + " not found");
        }

        byId.get().getReviews().add(reviewMapper.toEntity(reviewDTO));
    }
}
