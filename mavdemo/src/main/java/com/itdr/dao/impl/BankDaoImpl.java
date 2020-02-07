package com.itdr.dao.impl;

import com.itdr.dao.BankDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BankDaoImpl implements BankDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    // 扣钱
    @Override
    public int minusMoney(String aname, int money) {

        String sql = "update bank set score = score - ? where name = ?";
        int update = jdbcTemplate.update(sql, money, aname);
        return update;
    }

    // 加钱
    @Override
    public int addMoney(String bname, int money) {

        String sql = "update bank set score = score + ? where name = ?";
        int update = jdbcTemplate.update(sql, money, bname);
        return update;
    }

    @Override
    public void findAll() {
        System.out.println("查找");
    }

    @Override
    public void save() {
        System.out.println("保存");
    }

    @Override
    public void update() {
        System.out.println("更新");
    }

    @Override
    public void delete() {
        System.out.println("删除");
    }
}
