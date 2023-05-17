package com.elsad.demojpaapp.model.mapper;

import com.elsad.demojpaapp.model.dto.ReviewDTO;
import com.elsad.demojpaapp.model.entity.Review;


public interface ReviewMapper {

    ReviewDTO toDto(Review review);

    Review toEntity(ReviewDTO reviewDTO);

}
