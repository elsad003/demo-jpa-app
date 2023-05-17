package com.elsad.demojpaapp.model.mapper.impl;

import com.elsad.demojpaapp.model.dto.StudentInfoDTO;
import com.elsad.demojpaapp.model.entity.StudentInfo;
import com.elsad.demojpaapp.model.mapper.StudentInfoMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentInfoMapperImpl implements StudentInfoMapper {

    @Override
    public StudentInfoDTO toDto(StudentInfo studentInfo) {
        if (studentInfo != null) {
            StudentInfoDTO studentInfoDTO = new StudentInfoDTO();
            studentInfoDTO.setId(studentInfo.getId());
            studentInfoDTO.setPhoneNumber(studentInfo.getPhoneNumber());
            studentInfoDTO.setEmail(studentInfo.getEmail());
            return studentInfoDTO;
        }
        return null;
    }

    @Override
    public StudentInfo toEntity(StudentInfoDTO studentInfoDTO) {
        if (studentInfoDTO != null) {
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setId(studentInfoDTO.getId());
            studentInfo.setPhoneNumber(studentInfoDTO.getPhoneNumber());
            studentInfo.setEmail(studentInfoDTO.getEmail());
            return studentInfo;
        }
        return null;
    }
}
