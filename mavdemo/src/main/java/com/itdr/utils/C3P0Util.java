package com.itdr.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {

    //静态数据库连接池
    private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

    public static ComboPooledDataSource getComboPooledDataSource(){
        return comboPooledDataSource;
    }
}
