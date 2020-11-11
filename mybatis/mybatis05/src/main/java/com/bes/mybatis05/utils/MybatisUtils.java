package com.bes.mybatis05.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resourcePath = "mybatis-config.xml";
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(resourcePath);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
   }

}
