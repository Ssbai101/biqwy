<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 放网页的公共部分 -->
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Biq物业管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="sun_index.jsp">首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="/biqwy/sun/hlogin.jsp">管理员</a></li>
                <li><a href="/biqwy/manage/logout">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="/biqwy/sun/sun_domanselect"><i class="icon-font">&#xe008;</i>用户信息</a></li>
                        <li><a href="sun_new.jsp"><i class="icon-font">&#xe006;</i>公告管理</a></li>
                        <li><a href="sun_message.jsp"><i class="icon-font">&#xe004;</i>留言管理</a></li>             
                    </ul>
                </li>
            </ul>
        </div>
    </div>
 </div>