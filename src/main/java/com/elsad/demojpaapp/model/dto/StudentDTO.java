package com.elsad.demojpaapp.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {

    @JsonIgnore
    private Integer id;

    private String name;

    private StudentInfoDTO studentInfo;

    private List<CourseDTO> courses;
}
