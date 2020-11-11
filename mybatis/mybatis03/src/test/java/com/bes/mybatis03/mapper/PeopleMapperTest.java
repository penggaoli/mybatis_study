package com.bes.mybatis03.mapper;

import com.bes.mybatis03.pojo.People;
import com.bes.mybatis03.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class PeopleMapperTest {
    @Test
    public void getAllPeople() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PeopleMapper mapper = sqlSession.getMapper(PeopleMapper.class);
        List<People> allPeople = mapper.getAllPeople();
        for (People allPerson : allPeople) {
            System.out.println(allPerson);
        }
        sqlSession.close();
    }
}
