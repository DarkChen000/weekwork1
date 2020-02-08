package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.NameDao;
import com.itdr.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NameService {

    @Autowired
    private NameDao nameDao;


    public ResponseCode<Users> login(String username, String password) {
        // 参数非空判断
        if (username == null || "".equals(username)){
            return ResponseCode.toDefeated("输入错误！");
        }
        if (password == null || "".equals(password)){
            return ResponseCode.toDefeated("输入错误！");
        }
        int i = nameDao.selectByUserNameAndPassword(username, password);
        // 如果返回值为空，说明用户不存在，也就是登陆失败
        if (i == 0){
            return ResponseCode.toDefeated("用户不存在！");
        }
        // 成功则返回用户数据
        return ResponseCode.toSuccess("登陆成功！");
    }

    public ResponseCode<Users> register(String username, String password) {
        // 参数非空判断
        if (username == null || "".equals(username)){
            return ResponseCode.toDefeated("输入错误！");
        }
        if (password == null || "".equals(password)){
            return ResponseCode.toDefeated("输入错误！");
        }

        int i = nameDao.selectByUserNameAndPassword(username, password);
        if (i != 0){
            return ResponseCode.toDefeated("用户名已存在！");
        }

        int i1 = nameDao.insertByUserNameAndPassword(username, password);

        // 成功则返回用户数据
        if (i1 == 0){
            return ResponseCode.toDefeated("注册失败！");
        }
        return ResponseCode.toSuccess("注册成功");
    }

    public String game(String shengxiao, String month, String xingzuo) {
        // 参数非空判断
        if (shengxiao == null || "".equals(shengxiao)){
            return null;
        }
        if (month == null || "".equals(month)){
            return null;
        }
        if (xingzuo == null || "".equals(xingzuo)){
            return null;
        }

        String first = nameDao.selectByShengxiao(shengxiao);

        String second = nameDao.selectByMonth(month);

        String third = nameDao.selectByXingzuo(xingzuo);

        String a = first+second+third;

        return a;
    }
}
