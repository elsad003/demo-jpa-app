package com.elsad.demojpaapp.service.impl;

import com.elsad.demojpaapp.model.dto.CourseDTO;
import com.elsad.demojpaapp.model.dto.StudentDTO;
import com.elsad.demojpaapp.model.dto.StudentInfoDTO;
import com.elsad.demojpaapp.model.entity.Course;
import com.elsad.demojpaapp.model.entity.Student;
import com.elsad.demojpaapp.model.entity.StudentInfo;
import com.elsad.demojpaapp.model.mapper.CourseMapper;
import com.elsad.demojpaapp.model.mapper.StudentInfoMapper;
import com.elsad.demojpaapp.model.mapper.StudentMapper;
import com.elsad.demojpaapp.repository.CourseRepository;
import com.elsad.demojpaapp.repository.StudentInfoRepository;
import com.elsad.demojpaapp.repository.StudentRepository;
import com.elsad.demojpaapp.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final CourseMapper courseMapper;
    private final StudentInfoMapper studentInfoMapper;
    private final StudentInfoRepository studentInfoRepository;
    private final CourseRepository courseRepository;

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(studentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public StudentDTO findById(Integer id) {
        return studentMapper.toDto(studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student by id : " + id + "not found")));
    }

    @Override
    @Transactional
    public StudentDTO save(StudentDTO studentDTO) {

        Student student = new Student(studentDTO.getName(),
                studentInfoMapper.toEntity(studentDTO.getStudentInfo()),
                null);

        return studentMapper.toDto(studentRepository.save(student));
    }

    @Override
    @Transactional
    public StudentDTO update(Integer id, StudentDTO studentDTO) {

        Student student = studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student by id : " + id + "not found"));

        student.setName(studentDTO.getName());

        student.setStudentInfo(studentInfoMapper.toEntity(studentDTO.getStudentInfo()));


        return studentMapper.toDto(student);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void buyCourse(Integer studentId, Integer courseId) {
        Student student= studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Student by id : " + studentId + "not found"));
        student.getCourses().add(courseRepository.findById(courseId).orElseThrow(()->new RuntimeException("Course by id : " + studentId + "not found")));
    }
}
