package com.elsad.demojpaapp.api;

import com.elsad.demojpaapp.model.dto.ReviewDTO;
import com.elsad.demojpaapp.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ReviewApi {

    private final ReviewService reviewService;


    @PostMapping("/review/add/{courseId}")
    public ResponseEntity<?> addReview(@PathVariable Integer courseId, @RequestBody ReviewDTO reviewDTO){
        reviewService.add(courseId,reviewDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
