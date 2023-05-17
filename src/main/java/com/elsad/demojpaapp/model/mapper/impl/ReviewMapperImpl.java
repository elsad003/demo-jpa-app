package com.elsad.demojpaapp.model.mapper.impl;

import com.elsad.demojpaapp.model.dto.ReviewDTO;
import com.elsad.demojpaapp.model.entity.Review;
import com.elsad.demojpaapp.model.mapper.ReviewMapper;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public ReviewDTO toDto(Review review) {
        if (review != null) {
            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setId(review.getId());
            reviewDTO.setReview(review.getReview());
            reviewDTO.setStars(review.getStars());
            return reviewDTO;
        }
        return null;
    }

    @Override
    public Review toEntity(ReviewDTO reviewDTO) {
        if (reviewDTO != null) {
            Review review = new Review();
            review.setId(reviewDTO.getId());
            review.setReview(reviewDTO.getReview());
            review.setStars(reviewDTO.getStars());
            return review;
        }
        return null;
    }
}
