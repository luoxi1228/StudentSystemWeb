<%@ page import="com.pojo.student" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/5/20
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生信息</title>
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
            color: white; /* 标题文字颜色 */
        }
        #sidebar hr {
            text-align: center;
            color: white; /* 标题文字颜色 */
        }
        #sidebar h3 {
            text-align: center;
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
    <h1>学生</h1>
    <hr>
    <h3>功能选择</h3>
    <ul>
        <li><a href="/SSO/student/personGradeServlet">查看成绩</a></li>
        <li><a href="/SSO/student/totalRankServlet">查看排名</a></li>
        <li><a href="/SSO/student/courseSelectServlet">进行选课</a></li>
        <li><a href="/SSO/logoutServlet">退出登录</a></li>
    </ul>
</div>

<div id="content">
    <h2>学生个人信息</h2>
    <%-- 获取存储在 session 中的学生对象 --%>
    <%-- 显示学生个人信息 --%>
    <p>学号：${stu.s_id} </p>
    <p>姓名：${stu.s_name} </p>
    <p>性别：${stu.s_gender}</p>
    <p>年龄：${stu.s_age} </p>
    <p>学院：${stu.s_faculty} </p>
</div>
</body>
</html>
