<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/1/14
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
</head>
<body>
<form action="/user/login" method="post">
    <input type="text" placeholder="账户" name="username">
    <input type="password" placeholder="密码" name="password">
    <input type="submit" placeholder="登录">
    <a href="/index/register">注册</a>
</form>

</body>
</html>
