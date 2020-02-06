package com.itdr.dao;

import com.itdr.pojo.Users;
import com.itdr.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {

    public Users selectByUserNameAndPassword(String username, String password){

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getComboPooledDataSource());

        String sql = "select id,username,password from user where username = ? and password = ?";

        Users u = null;

        try {
            u = queryRunner.query(sql, new BeanHandler<Users>(Users.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public int insertByUserNameAndPassword(String username, String password) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getComboPooledDataSource());

        String sql = "insert into user values(null,?,?)";

        int i = 0;

        try {
            i = queryRunner.update(sql, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
