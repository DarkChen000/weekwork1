package com.itdr.controller;

import com.itdr.service.BankService;
import com.itdr.service.impl.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class BankController {

//    private static ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

    @Autowired
    private BankService bs;

    // 模拟转账
    public String zz(String aname,String bname,int money){

        String tm = bs.tm(aname, bname, money);
        return tm;

    }

    // 模拟转账
    public void zz2(String aname,String bname,int money){

        bs.tm2(aname, bname, money);

    }
}
