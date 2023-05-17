package com.elsad.demojpaapp.service.impl;

import com.elsad.demojpaapp.model.dto.CourseDTO;
import com.elsad.demojpaapp.model.entity.Course;
import com.elsad.demojpaapp.model.entity.Student;
import com.elsad.demojpaapp.model.mapper.CourseMapper;
import com.elsad.demojpaapp.model.mapper.ReviewMapper;
import com.elsad.demojpaapp.model.mapper.StudentMapper;
import com.elsad.demojpaapp.repository.CourseRepository;
import com.elsad.demojpaapp.service.CourseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final ReviewMapper reviewMapper;
    private final StudentMapper studentMapper;

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream().map(courseMapper::toDto).toList();
    }

    @Override
    public CourseDTO findById(Integer id) {
        return courseMapper.toDto(courseRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Course by id : " + id + " not found")));
    }

    @Override
    @Transactional
    public CourseDTO save(CourseDTO courseDTO) {
        return courseMapper.toDto(courseRepository.save(courseMapper.toEntity(courseDTO)));
    }

    @Override
    @Transactional
    public CourseDTO update(Integer id, CourseDTO courseDTO) {

        Course course = courseRepository.findById(id).orElseThrow(()-> new RuntimeException("Course by id : " + id + " not found"));

        course.setName(courseDTO.getName());
        course.setReviews(courseDTO.getReviews().stream().map(reviewMapper::toEntity).collect(Collectors.toList()));
        course.setLectureCount(courseDTO.getLectureCount());
        course.setStudents(courseDTO.getStudents().stream().map(studentMapper::toEntity).collect(Collectors.toList()));

        return courseMapper.toDto(course);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Course course = courseRepository.findById(id).orElse(null);

        if (course != null) {
            List<Student> students = course.getStudents();

            for (Student student : students) {
                student.getCourses().remove(course);
            }

            course.getStudents().clear();

            courseRepository.delete(course);
        }
    }
}
