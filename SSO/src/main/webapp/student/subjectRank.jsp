<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/5/21
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
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
            position: sticky;
            top: 0;
            z-index: 1;
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

        #class-info {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
            margin-bottom: 20px;
        }

        .info-item {
            background-color: #f9f9f9;
            border: 1px solid #ddd;
            padding: 10px;
            border-radius: 4px;
            flex: 1;
        }

        #content hr {
            border: none;
            border-top: 1px solid #ddd;
            margin: 20px 0;
        }
    </style>
</head>
<body>
<div id="sidebar">
    <h1>学生</h1>
    <hr>
    <h3>功能选择</h3>
    <ul>
        <li><a href="/SSO/student/otherRank.jsp">返回</a></li>
    </ul>
</div>

<div id="content">
    <h2>学生：${stu.s_name}</h2>
    <hr>
    <div id="class-info">
        <div class="info-item">
            <strong>学科：</strong> ${courseName}
        </div>
        <div class="info-item">
            <strong>排名：</strong>${mySubRank}
        </div>
    </div>
    <hr>
    <h3>排名信息</h3>
    <div id="rank-container">
        <table id="rankTable">
            <thead>
            <tr>
                <th> 学号</th>
                <th> 姓名</th>
                <th>学科成绩</th>
                <th> 排名</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${subRanks}" var="subRanks">
                <tr>
                    <td>${subRanks.s_id}</td>
                    <td>${subRanks.s_name}</td>
                    <td>${subRanks.finalGrade}</td>
                    <td>${subRanks.rank}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
