package com.elsad.demojpaapp.model.mapper.impl;

import com.elsad.demojpaapp.model.dto.CourseDTO;
import com.elsad.demojpaapp.model.dto.ReviewDTO;
import com.elsad.demojpaapp.model.dto.StudentDTO;
import com.elsad.demojpaapp.model.dto.StudentInfoDTO;
import com.elsad.demojpaapp.model.entity.Course;
import com.elsad.demojpaapp.model.entity.Review;
import com.elsad.demojpaapp.model.entity.Student;
import com.elsad.demojpaapp.model.entity.StudentInfo;
import com.elsad.demojpaapp.model.mapper.StudentMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDTO toDto(Student student) {
        if (student != null) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(student.getId());
            studentDTO.setName(student.getName());
            studentDTO.setStudentInfo(toStudentInfoDTO(student.getStudentInfo()));
            studentDTO.setCourses(toCourseDTOList(student.getCourses()));
            return studentDTO;
        }
        return null;
    }

    @Override
    public Student toEntity(StudentDTO studentDTO) {
        if (studentDTO != null) {
            Student student = new Student();
            student.setId(studentDTO.getId());
            student.setName(studentDTO.getName());
            student.setStudentInfo(toStudentInfo(studentDTO.getStudentInfo()));
            student.setCourses(toCourseList(studentDTO.getCourses()));
            return student;
        }
        return null;
    }

    private StudentInfoDTO toStudentInfoDTO(StudentInfo studentInfo) {
        if (studentInfo != null) {
            StudentInfoDTO studentInfoDTO = new StudentInfoDTO();
            studentInfoDTO.setId(studentInfo.getId());
            studentInfoDTO.setPhoneNumber(studentInfo.getPhoneNumber());
            studentInfoDTO.setEmail(studentInfo.getEmail());
            return studentInfoDTO;
        }
        return null;
    }

    private StudentInfo toStudentInfo(StudentInfoDTO studentInfoDTO) {
        if (studentInfoDTO != null) {
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setId(studentInfoDTO.getId());
            studentInfo.setPhoneNumber(studentInfoDTO.getPhoneNumber());
            studentInfo.setEmail(studentInfoDTO.getEmail());
            return studentInfo;
        }
        return null;
    }

    private List<CourseDTO> toCourseDTOList(List<Course> courses) {
        List<CourseDTO> courseDTOs = new ArrayList<>();
        if (courses != null) {
            for (Course course : courses) {
                CourseDTO courseDTO = new CourseDTO();
                courseDTO.setId(course.getId());
                courseDTO.setName(course.getName());
                courseDTO.setLectureCount(course.getLectureCount());
                // Map other fields if needed
                courseDTOs.add(courseDTO);
            }
        }
        return courseDTOs;
    }

    private List<Course> toCourseList(List<CourseDTO> courseDTOs) {
        List<Course> courses = new ArrayList<>();
        if (courseDTOs != null) {
            for (CourseDTO courseDTO : courseDTOs) {
                Course course = new Course();
                course.setId(courseDTO.getId());
                course.setName(courseDTO.getName());
                course.setLectureCount(courseDTO.getLectureCount());
                // Map other fields if needed
                courses.add(course);
            }
        }
        return courses;
    }
}
