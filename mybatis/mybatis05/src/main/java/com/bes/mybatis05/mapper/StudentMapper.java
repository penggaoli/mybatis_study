package com.bes.mybatis05.mapper;

import com.bes.mybatis05.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getAllStudent();

    List<Student> getAllStudent2();
}
