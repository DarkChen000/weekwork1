package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import com.itdr.service.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/user/*")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

//    ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
//    UserServiceImpl userService = (UserServiceImpl) ac.getBean("userService");

    private UserService userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String[] split = requestURI.split("/");

        // 登录
        if ("login".equals(split[split.length - 1])){
            login(request,response);
        }

        // 注册
        if ("re".equals(split[split.length - 1])){
            register(request,response);
        }

    }


    // 登录
    private void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ResponseCode<Users> login = userService.login(username, password);

        // 用session存用户信息，标记为us
        HttpSession session = request.getSession();
        Users data = login.getData();
        session.setAttribute("us",data);

        if (login != null){
            request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
        }


    }

    // 注册
    private void register(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("rusername");
        String password = request.getParameter("rpassword");

        ResponseCode<Users> register = userService.register(username, password);


        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

}
