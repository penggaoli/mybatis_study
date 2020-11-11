package com.bes.mybatis_demo01.dao;

import com.bes.mybatis_demo01.pojo.People;

import java.util.List;

public interface PeopleMapper {
    List<People> getAllPeople();

    People getPeopleById(int id);

    int insertPeople(People people);

    int updatePeople(People people);

    int deletePeopleById(int id);
}
