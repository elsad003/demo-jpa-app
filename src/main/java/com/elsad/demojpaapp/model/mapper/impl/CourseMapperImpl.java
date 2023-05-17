package com.elsad.demojpaapp.model.mapper.impl;

import com.elsad.demojpaapp.model.dto.CourseDTO;
import com.elsad.demojpaapp.model.dto.ReviewDTO;
import com.elsad.demojpaapp.model.dto.StudentDTO;
import com.elsad.demojpaapp.model.dto.StudentInfoDTO;
import com.elsad.demojpaapp.model.entity.Course;
import com.elsad.demojpaapp.model.entity.Review;
import com.elsad.demojpaapp.model.entity.Student;
import com.elsad.demojpaapp.model.entity.StudentInfo;
import com.elsad.demojpaapp.model.mapper.CourseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public CourseDTO toDto(Course course) {
        if (course != null) {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setId(course.getId());
            courseDTO.setName(course.getName());
            courseDTO.setLectureCount(course.getLectureCount());
            courseDTO.setStudents(toStudentDTOList(course.getStudents()));
            courseDTO.setReviews(toReviewDTOList(course.getReviews()));
            return courseDTO;
        }
        return null;
    }

    @Override
    public Course toEntity(CourseDTO courseDTO) {
        if (courseDTO != null) {
            Course course = new Course();
            course.setId(courseDTO.getId());
            course.setName(courseDTO.getName());
            course.setLectureCount(courseDTO.getLectureCount());
            course.setStudents(toStudentList(courseDTO.getStudents()));
            course.setReviews(toReviewList(courseDTO.getReviews()));
            return course;
        }
        return null;
    }

    private List<StudentDTO> toStudentDTOList(List<Student> students) {
        List<StudentDTO> studentDTOs = new ArrayList<>();
        if (students != null) {
            for (Student student : students) {
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.setId(student.getId());
                studentDTO.setName(student.getName());
                // Map other fields if needed
                studentDTOs.add(studentDTO);
            }
        }
        return studentDTOs;
    }

    private List<Student> toStudentList(List<StudentDTO> studentDTOs) {
        List<Student> students = new ArrayList<>();
        if (studentDTOs != null) {
            for (StudentDTO studentDTO : studentDTOs) {
                Student student = new Student();
                student.setId(studentDTO.getId());
                student.setName(studentDTO.getName());
                // Map other fields if needed
                students.add(student);
            }
        }
        return students;
    }

    private List<ReviewDTO> toReviewDTOList(List<Review> reviews) {
        List<ReviewDTO> reviewDTOs = new ArrayList<>();
        if (reviews != null) {
            for (Review review : reviews) {
                ReviewDTO reviewDTO = new ReviewDTO();
                reviewDTO.setId(review.getId());
                reviewDTO.setReview(review.getReview());
                reviewDTO.setStars(review.getStars());
                // Map other fields if needed
                reviewDTOs.add(reviewDTO);
            }
        }
        return reviewDTOs;
    }

    private List<Review> toReviewList(List<ReviewDTO> reviewDTOs) {
        List<Review> reviews = new ArrayList<>();
        if (reviewDTOs != null) {
            for (ReviewDTO reviewDTO : reviewDTOs) {
                Review review = new Review();
                review.setId(reviewDTO.getId());
                review.setReview(reviewDTO.getReview());
                review.setStars(reviewDTO.getStars());
                // Map other fields if needed
                reviews.add(review);
            }
        }
        return reviews;
    }
}