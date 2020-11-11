package com.bes.mybatis04.mapper;


import com.bes.mybatis04.pojo.People;

import java.util.List;
import java.util.Map;

public interface PeopleMapper {
    List<People> getAllPeople();

    People getPeopleById(int id);
    
    int insertPeople(People people);

    int updatePeople(People people);

    int deletePeopleById(int id);

    List<People> getPeopleLimit(Map<String, Integer> map);
}
