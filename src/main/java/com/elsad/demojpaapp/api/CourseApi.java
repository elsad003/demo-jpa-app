package com.elsad.demojpaapp.api;

import com.elsad.demojpaapp.model.dto.CourseDTO;
import com.elsad.demojpaapp.model.dto.StudentDTO;
import com.elsad.demojpaapp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CourseApi {

    private final CourseService courseService;

    @GetMapping("/course")
    public ResponseEntity<List<CourseDTO>> findAll(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(courseService.findById(id));
    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        courseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
