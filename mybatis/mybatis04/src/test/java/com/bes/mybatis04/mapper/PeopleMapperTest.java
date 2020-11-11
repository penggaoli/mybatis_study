package com.bes.mybatis04.mapper;


import com.bes.mybatis04.pojo.People;
import com.bes.mybatis04.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.net.SocketTimeoutException;
import java.sql.ParameterMetaData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleMapperTest {
    Logger logger = Logger.getLogger(PeopleMapperTest.class);
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

    @Test
    public void getPeopleLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PeopleMapper mapper = sqlSession.getMapper(PeopleMapper.class);
        Map<String, Integer> map = new HashMap<String, Integer>(2);
        map.put("startIndex", 0);
        map.put("pageSize", 2);
        List<People> peopleLimit = mapper.getPeopleLimit(map);
        for (People people : peopleLimit) {
            logger.info(people);
        }
        sqlSession.close();
    }

    @Test
    public void logTest() {
        logger.info("info: into logTest");
        logger.debug("debug: into logTest");
        logger.error("error: into logTest");
    }
}