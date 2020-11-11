package com.bes.mybatis05.mapper;

import com.bes.mybatis05.pojo.Student;
import com.bes.mybatis05.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.swing.plaf.SliderUI;
import java.util.List;

public class StudentMapperTest {
    @Test
    public void getAllStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> allStudent = mapper.getAllStudent();
        for (Student student : allStudent) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void getAllStudent2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> allStudent = mapper.getAllStudent2();
        for (Student student : allStudent) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
