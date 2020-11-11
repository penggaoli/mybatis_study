package com.bes.mybatis_demo01.dao;

import com.bes.mybatis_demo01.pojo.People;
import com.bes.mybatis_demo01.utils.MybatisUtils;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class PeopleMapperTest {
    @Test
    public void getAllPeople() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PeopleMapper peopleMapper = sqlSession.getMapper(PeopleMapper.class);

        List<People> allPeople = peopleMapper.getAllPeople();

        for (People allPerson : allPeople) {
            System.out.println(allPerson);
        }
        sqlSession.close();
    }

    @Test
    public void getPeopleById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PeopleMapper mapper = sqlSession.getMapper(PeopleMapper.class);

        People peopleById = mapper.getPeopleById(1);
        System.out.println(peopleById);
        sqlSession.close();
    }

    @Test
    public void insertPeople() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PeopleMapper mapper = sqlSession.getMapper(PeopleMapper.class);

        mapper.insertPeople(new People(1, "彭高历", "123123", "12313@qq.com"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updatePeople() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PeopleMapper mapper = sqlSession.getMapper(PeopleMapper.class);
        mapper.updatePeople(new People(2, "冯雪珂", "feng523319", "feng@123.com"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deletePeople() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PeopleMapper mapper = sqlSession.getMapper(PeopleMapper.class);

        mapper.deletePeopleById(2);
        sqlSession.commit();
        sqlSession.close();
    }
}
