<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/5/23
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>管理员</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
        }

        #sidebar {
            float: left;
            width: 200px;
            height: 100%;
            background-color: #007BFF; /* 蓝色背景 */
            padding-top: 20px;
            position: fixed;
        }
        #sidebar h1 {
            text-align: center;
            color: white; /* 标题文字
颜色 */
        }

        #sidebar h3 {
            text-align: center;
            color: white; /* 标题文字
颜色 */
        }
        #sidebar hr {
            color: white; /* 标题文字
颜色 */
        }

        #sidebar ul {
            list-style-type: none;
            padding: 0;
        }

        #sidebar ul li {
            text-align: center;
            margin: 10px 0;
        }

        #sidebar ul li a {
            display: block;
            padding: 10px;
            text-decoration: none;
            color: white; /* 链接文字颜色 */
            background-color: #0056b3; /* 链接的背景颜色 */
            border-radius: 4px;
        }

        #sidebar ul li a:hover {
            background-color: #004494; /* 链接悬停背景颜色 */
        }

        #content {
            margin-left: 220px; /* 调整左边距以适应侧边栏宽度 */
            padding: 20px;
        }

        #content h2 {
            border-bottom: 2px solid #ccc;
            padding-bottom: 10px;
        }

        #content p {
            font-size: 18px;
            line-height: 1.6;
        }
    </style>
</head>
<body>
<div id="sidebar">
    <h1>管理员</h1>
    <hr>
    <h3>功能选择</h3>
    <ul>
        <li><a href="/SSO/admin/classManageServlet">班级管理</a></li>
        <li><a href="/SSO/admin/courseManageServlet">课程管理</a></li>
        <li><a href="/SSO/logoutServlet">退出登录</a></li>
    </ul>
</div>
<div id="content">
    <h2>管理员信息</h2>
    <p>账号：${admin.account} </p>
</div>
</body>
</html>
