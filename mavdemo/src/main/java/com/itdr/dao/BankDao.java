package com.itdr.dao;

public interface BankDao {

    int minusMoney(String aname,int money);

    int addMoney(String bname,int money);

    void findAll();

    void save();

    void update();

    void delete();
}
