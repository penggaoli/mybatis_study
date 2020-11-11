package com.bes.mapper;

import com.bes.pojo.People;
import org.apache.ibatis.annotations.Param;

public interface PeopleMapper {
    People getBeopleById(@Param("id")int id);
}
