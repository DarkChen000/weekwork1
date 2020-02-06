<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/2/5
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<div>
<form action="/user/re" method="post">
    <input type="text" placeholder="用户名" name="rusername">
    <input type="text" placeholder="密码" name="rpassword">
    <input type="submit" value="注册">
</form>
</div>
</body>
</html>
