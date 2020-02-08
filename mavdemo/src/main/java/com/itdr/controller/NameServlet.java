package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.NameService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/name/*")
@Controller
public class NameServlet extends HttpServlet {

    // 陈春辉作业：前世你的名字

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    static ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

//    @Autowired
//    private NameService nameService;

    static NameService nameService = ac.getBean(NameService.class);




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

        // 测试名字
        if ("game".equals(split[split.length - 1])){
            game(request,response);
        }
    }

    // 登录
    private void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");


        ResponseCode<Users> login = nameService.login(username, password);


        if (login != null){
            request.getRequestDispatcher("/WEB-INF/name/qsname.jsp").forward(request,response);
        }

    }

    // 注册
    private void register(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("nusername");
        String password = request.getParameter("npassword");

        ResponseCode<Users> login = nameService.register(username, password);

        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    // 游戏界面
    private void game(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");

        String shengxiao = request.getParameter("shengxiao");
        String month = request.getParameter("month");
        String xingzuo = request.getParameter("xingzuo");

        String name = nameService.game(shengxiao, month, xingzuo);

        request.setAttribute("name",name);

        System.out.println(shengxiao);

        request.getRequestDispatcher("/WEB-INF/name/qsname.jsp").forward(request,response);
    }
}
