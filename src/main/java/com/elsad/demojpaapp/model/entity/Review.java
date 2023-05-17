package com.elsad.demojpaapp.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "review")
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String review;

    private Integer stars;

    public Review(String review, Integer stars) {
        this.review = review;
        this.stars = stars;
    }
}
