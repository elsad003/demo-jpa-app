package com.elsad.demojpaapp.repository;

import com.elsad.demojpaapp.model.entity.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInfoRepository extends JpaRepository<StudentInfo,Integer> {
}
