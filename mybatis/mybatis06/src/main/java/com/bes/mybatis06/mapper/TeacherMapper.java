package com.bes.mybatis06.mapper;

import com.bes.mybatis06.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    public List<Teacher> getTeachers();
    Teacher getTeacherById(@Param("tid") int id);
    Teacher getTeacherById2(@Param("tid") int id);
}
