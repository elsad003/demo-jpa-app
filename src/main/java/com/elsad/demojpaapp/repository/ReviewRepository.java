package com.elsad.demojpaapp.repository;

import com.elsad.demojpaapp.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
}
