<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/2/8
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>前世名字</title>
</head>
<body>
<div>
    <form action="/name/game" method="post">
        <input type="text" placeholder="你的生肖（示例：狗）" name="shengxiao">
        <input type="text" placeholder="你的生日月份（示例：12月）" name="month">
        <input type="text" placeholder="你的星座（示例：魔羯座）" name="xingzuo">
        <input type="submit" value="查看我的前世名字">
    </form>
    <div><span>你前世的名字是：${name}</span></div>
</div>
</body>
</html>
