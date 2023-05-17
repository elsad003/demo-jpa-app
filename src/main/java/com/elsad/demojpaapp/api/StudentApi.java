package com.elsad.demojpaapp.api;

import com.elsad.demojpaapp.model.dto.StudentDTO;
import com.elsad.demojpaapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class StudentApi {

    private final StudentService studentService;

    @GetMapping("/student")
    public ResponseEntity<List<StudentDTO>> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        studentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/student")
    public ResponseEntity<?> save(@RequestBody StudentDTO studentDTO){
        StudentDTO save = studentService.save(studentDTO);
        URI url= URI.create("/api/v1/student/"+save.getId());
        return ResponseEntity.created(url).body(save);
    }

    @PostMapping("/student/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody StudentDTO studentDTO){
        StudentDTO update = studentService.update(id, studentDTO);
        return ResponseEntity.ok(update);
    }
 
    @PostMapping("/student/{studentID}/course/{courseID}")
    public ResponseEntity<?> addCourse(@PathVariable("studentID") Integer studentId, @PathVariable("courseID") Integer courseId){
        studentService.buyCourse(studentId,courseId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
