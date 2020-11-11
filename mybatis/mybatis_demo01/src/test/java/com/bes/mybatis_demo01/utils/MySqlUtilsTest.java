package com.bes.mybatis_demo01.utils;

import com.mysql.jdbc.MysqlIO;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlUtilsTest {
    @Test
    public void getConnection() {
        ResultSet rs = null;
        Statement st = null;
        Connection cn = null;

        try {
            cn = MySqlUtils.getConnection();
            String sql = "select * from people";
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("password"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getDate("birthday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlUtils.releaseResource(rs, st, cn);
        }
    }
}
