<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/jquery-1.12.4.min.js"></script>
    <script src="js/function.js"></script>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="register" method="post" onsubmit="return checkForm(this)"><h1><a href="index.html"><img src="">BIQ物业管理系统</a></h1>
        <p>用户注册</p>
        <p><input type="text" name="username" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入用户名"><span></span></p>
        <p><input type="text" name="name" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入名字"><span></span></p>
        <p><input type="text" name="password" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入密码"><span></span></p>
        <p><input type="text" name="repassword" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请确认密码"><span></span></p>
        <p>
           <input style="width:15px;height:15px" type="radio" name="sex" value="T"  checked="checked">男
           <input style="width:15px;height:15px"type="radio" name="sex" value="F"  >女
        </p>
        <p><input type="text" name="addr" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入地址"><span></span></p> 
        <p><input type="text" name="memo" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入备注"><span></span></p> 
        <p class="txtL txt"><input class="code" type="text" name="veryCode" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="验证码"><img
                src="getCode" alt="看不清。换一张" onclick="change(this)" onfocus="FocusItem(this)" onblur="CheckItem(this)"><span></span></p>
        <p><input type="submit" name="" value="注册"></p>
     </form>
</div>
</body>
</html>