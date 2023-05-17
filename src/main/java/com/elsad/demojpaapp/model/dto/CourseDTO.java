package com.elsad.demojpaapp.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {

    private Integer id;

    private String name;

    private Integer lectureCount;

    private List<StudentDTO> students;

    private List<ReviewDTO> reviews;
}

