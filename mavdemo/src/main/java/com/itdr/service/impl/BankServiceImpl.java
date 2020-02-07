package com.itdr.service.impl;

import com.itdr.dao.BankDao;
import com.itdr.dao.impl.BankDaoImpl;
import com.itdr.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
@Transactional
public class BankServiceImpl implements BankService {

    @Autowired
    private BankDao bd;

    @Autowired
    private TransactionTemplate tt;


    @Override
    public String tm(String aname, String bname, int money) {

        // 从a账户扣钱
        int i = bd.minusMoney(aname, money);

//        int a = 1 / 0;

        //给b账户加钱
        int i1 = bd.addMoney(bname, money);

        if(i != 1 || i1 != 1){
            return "转账失败!";
        }
        return "转账成功!";
    }

    @Override
    public void tm2(String aname, String bname, int money) {

        tt.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                // 从a账户扣钱
                int i = bd.minusMoney(aname, money);

//                int a = 1/0;

                //给b账户加钱
                int i1 = bd.addMoney(bname, money);
            }
        });

    }

}
