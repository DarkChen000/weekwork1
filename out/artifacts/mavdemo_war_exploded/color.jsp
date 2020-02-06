<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/2/6
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jQuery练习</title>
    <style type="text/css">
        .div1{

            float: left;
            width: 50px;
            line-height: 30px;
            background-color: lightgray;
            margin-left: 10px;
            text-align: center;
            vertical-align: middle;
        }
        .div2{
            width: 300px;
            height: 300px;
            border: solid gray 1px;
            margin-top: 60px;
            color: red;
        }
        .div3{
            float: left;
            width: 50px;
            line-height: 30px;
            background-color: lightgray;
            margin-left: 10px;
            text-align: center;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<h2>请选择背景颜色</h2>
<div>
    <div id="blue" class="div1">
        <button id="b1" onclick="toBlue(this)">蓝色</button>
    </div>
    <div id="green" class="div3" onclick="toGreen(this)">
        <button id="b2" onclick="toGreen(this)">绿色</button>
    </div>
</div>
<div class="div2" id="bg"></div>
<div>输入颜色首字母： <input type="text" name="color" id="in" placeholder="请输入B或者G"></div>
</body>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">

    alert("欢迎来到斑斓界--流光梦境")

    function toBlue() {
        document.getElementById("bg").style.backgroundColor="blue";
        document.getElementById("bg").innerHTML="蓝色背景";
    }
    function toGreen() {
        document.getElementById("bg").style.backgroundColor="green";
        document.getElementById("bg").innerHTML="<span style='font-weight: bolder;font-style:italic'>绿色背景</span>";
    }

    $(document).ready(function () {
        $('#in').mousedown(function () {
            var color = $('#in').val()
            if(color === 'B'){
                document.getElementById("bg").style.backgroundColor="blue";
                document.getElementById("bg").innerHTML=null;
            }
            if (color === 'G'){
                document.getElementById("bg").style.backgroundColor="green";
                document.getElementById("bg").innerHTML=null;
            }
        })
    })


</script>

</html>
