package com.elsad.demojpaapp;

import com.elsad.demojpaapp.model.entity.Course;
import com.elsad.demojpaapp.model.entity.Review;
import com.elsad.demojpaapp.model.entity.Student;
import com.elsad.demojpaapp.model.entity.StudentInfo;
import com.elsad.demojpaapp.repository.CourseRepository;
import com.elsad.demojpaapp.repository.ReviewRepository;
import com.elsad.demojpaapp.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BootstrapDB implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ReviewRepository reviewRepository;


    @Override
    @Transactional
    public void run(String... args) throws Exception {



        Review review = reviewRepository.save(new Review("very very bad",0));
        Review review1 = reviewRepository.save(new Review("very bad",1));
        Review review2 = reviewRepository.save(new Review("bad",2));
        Review review3 = reviewRepository.save(new Review("not bad",3));
        Review review4 = reviewRepository.save(new Review("middle",4));
        Review review5 = reviewRepository.save(new Review("not good",5));
        Review review6 = reviewRepository.save(new Review("good",6));
        Review review7 = reviewRepository.save(new Review("very good",7));
        Review review8 = reviewRepository.save(new Review("very very good",8));
        Review review9 = reviewRepository.save(new Review("excellent",9));
        Review review10 = reviewRepository.save(new Review("perfect",10));



        Student student = studentRepository.save(new Student("Elsad",
                new StudentInfo("+994-1000", "e03@gmail.com"),
                new ArrayList<>()));

        Student student1 = studentRepository.save(new Student("Haqverdi",
                new StudentInfo("+994-1001", "H.m02@gmail.com"),
                new ArrayList<>()));

        Student student2 = studentRepository.save(new Student("resid",
                new StudentInfo("+994-1002", "resid03@gmail.com"),
                new ArrayList<>()));

        Course course = courseRepository.save(new Course("Java", 300,
                new ArrayList<>(),
                new ArrayList<>(List.of(review1, review4, review7))));

        Course course1 = courseRepository.save(new Course("Python", 246,
                new ArrayList<>(),
                new ArrayList<>(List.of(review3, review6, review9, review10))));

        Course course2 = courseRepository.save(new Course("JavaScript", 500,
                new ArrayList<>(),
                new ArrayList<>(List.of(review2, review5, review8, review))));

        student.getCourses().add(course);
        student.getCourses().add(course1);
        student1.getCourses().add(course1);
        student2.getCourses().add(course2);

        studentRepository.save(student);
        studentRepository.save(student1);
        studentRepository.save(student2);

        course.getStudents().add(student);
        course1.getStudents().add(student);
        course2.getStudents().add(student);
        course1.getStudents().add(student1);
        course2.getStudents().add(student2);

        courseRepository.save(course);
        courseRepository.save(course1);
        courseRepository.save(course2);

        Course phpCourse = new Course("PHP", 100, new ArrayList<>(), new ArrayList<>());
        Course savedPhpCourse = courseRepository.save(phpCourse);

        // Retrieve all students
        List<Student> students = studentRepository.findAll();

        // Add the PHP course to each student
        for (Student tempStudent : students) {
            tempStudent.getCourses().add(savedPhpCourse);
        }

        // Save the updated students
        studentRepository.saveAll(students);

        // Add the students to the PHP course
        savedPhpCourse.getStudents().addAll(students);
        courseRepository.save(savedPhpCourse);


    }
}
