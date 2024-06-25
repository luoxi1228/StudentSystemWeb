<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/5/21
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>排名</title>
    <!-- 引入Font Awesome CSS库 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
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
            color: white; /* 标题文字颜色 */
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

        #content h2, #content h3 {
            color: #333;
        }

        #rank-container {
            height: 400px; /* 固定高度 */
            overflow-y: scroll; /* 垂直滚动条 */
            border: 1px solid #ddd;
            padding: 10px;
            margin-top: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
            cursor: pointer;
        }

        .sort-icon {
            margin-left: 5px;
        }

        #bottom-buttons {
            margin-top: 20px;
            text-align: center;
        }

        #bottom-buttons a {
            display: inline-block;
            padding: 10px 20px;
            margin-right: 10px;
            text-decoration: none;
            color: white;
            background-color: #007BFF;
            border-radius: 4px;
        }

        #bottom-buttons a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div id="sidebar">
    <h1>学生</h1>
    <hr>
    <h3>功能选择</h3>
    <ul>
        <li><a href="/SSO/student/studentHome.jsp">返回个人信息</a></li>
    </ul>
</div>

<div id="content">
    <h2>学生：${stu.s_name},  排名：${yourRank}</h2>
    <hr>
    <h3>排名信息</h3>
    <div id="rank-container">
        <table id="rankTable">
            <tr>
                <th> 学号</th>
                <th> 姓名</th>
                <th>总成绩</th>
                <th> 排名</th>
            </tr>
            <c:forEach items="${totalRanks}" var="totalRanks">
                <tr>
                    <td>${totalRanks.s_id}</td>
                    <td>${totalRanks.s_name}</td>
                    <td>${totalRanks.s_grade}</td>
                    <td>${totalRanks.total_rank}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="bottom-buttons">
        <a href="/SSO/student/otherRank.jsp">其他排名</a>
    </div>
</div>
</body>
</html>
