package com.elsad.demojpaapp.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_info")
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String phoneNumber;

    private String email;

    public StudentInfo(String phoneNumber, String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
