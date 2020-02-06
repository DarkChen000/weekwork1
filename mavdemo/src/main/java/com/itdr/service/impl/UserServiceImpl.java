package com.itdr.service.impl;

import com.itdr.common.ResponseCode;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;


public class UserServiceImpl implements UserService{

//    ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
//    UserDao userDao = (UserDao) ac.getBean("userDao");

    private UserDao userDao = new UserDao();

    // 登录

    @Override
    public ResponseCode<Users> login(String username, String password) {
        // 参数非空判断
        if (username == null || "".equals(username)){
            return ResponseCode.toDefeated("输入错误！");
        }
        if (password == null || "".equals(password)){
            return ResponseCode.toDefeated("输入错误！");
        }
        Users users = userDao.selectByUserNameAndPassword(username, password);
        // 如果返回值为空，说明用户不存在，也就是登陆失败
        if (users == null){
            return ResponseCode.toDefeated("用户不存在！");
        }
        // 成功则返回用户数据
        return ResponseCode.toSuccess(users);
    }

    // 注册
    @Override
    public ResponseCode<Users> register(String username, String password) {
        // 参数非空判断
        if (username == null || "".equals(username)){
            return ResponseCode.toDefeated("输入错误！");
        }
        if (password == null || "".equals(password)){
            return ResponseCode.toDefeated("输入错误！");
        }

        Users users = userDao.selectByUserNameAndPassword(username, password);
        if (users != null){
            return ResponseCode.toDefeated("用户名已存在！");
        }

        int i = userDao.insertByUserNameAndPassword(username, password);

        // 成功则返回用户数据
        if (i == 0){
            return ResponseCode.toDefeated("注册失败！");
        }
        return ResponseCode.toSuccess("注册成功");
    }
}
