package com.elsad.demojpaapp.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReviewDTO {

    @JsonIgnore
    private Integer id;

    private String review;

    private Integer stars;
}
