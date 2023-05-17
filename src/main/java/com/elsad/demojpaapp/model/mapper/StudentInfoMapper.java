package com.elsad.demojpaapp.model.mapper;

import com.elsad.demojpaapp.model.dto.StudentInfoDTO;
import com.elsad.demojpaapp.model.entity.StudentInfo;


public interface StudentInfoMapper {

    StudentInfoDTO toDto(StudentInfo studentInfo);

    StudentInfo toEntity(StudentInfoDTO studentInfoDTO);
}
