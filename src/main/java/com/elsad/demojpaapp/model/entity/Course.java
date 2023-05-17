package com.elsad.demojpaapp.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "course")
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer lectureCount;

    @ManyToMany(mappedBy = "courses",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Student> students;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    public Course(String name, Integer lectureCount, List<Student> students, List<Review> reviews) {
        this.name = name;
        this.lectureCount = lectureCount;
        this.students = students;
        this.reviews = reviews;
    }
}

