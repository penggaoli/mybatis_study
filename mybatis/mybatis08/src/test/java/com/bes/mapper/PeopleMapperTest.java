package com.bes.mapper;

import com.bes.pojo.People;
import com.bes.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class PeopleMapperTest {
    @Test
    public void getPeopleByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PeopleMapper peopleMapper = sqlSession.getMapper(PeopleMapper.class);
        People people = peopleMapper.getBeopleById(1);
        System.out.println(people);
        System.out.println("===================================");
        People people1 = peopleMapper.getBeopleById(3);
        System.out.println(people1);
        sqlSession.close();
    }

    @Test
    public void getPeopleByIdTest2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PeopleMapper peopleMapper = sqlSession.getMapper(PeopleMapper.class);
        People people = peopleMapper.getBeopleById(1);
        System.out.println(people);
        sqlSession.close();


        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        PeopleMapper peopleMapper1 = sqlSession1.getMapper(PeopleMapper.class);
        People people1 = peopleMapper1.getBeopleById(1);
        System.out.println(people1);
        sqlSession1.close();
    }

}
