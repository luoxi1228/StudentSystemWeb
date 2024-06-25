<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/5/21
  Time: 17:24
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
            background-color: #f5f5f5;
        }

        #sidebar {
            float: left;
            width: 200px;
            height: 100%;
            background-color: #007BFF;
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
            color: white;
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
            color: white;
            background-color: #0056b3;
            border-radius: 4px;
        }

        #sidebar ul li a:hover {
            background-color: #004494;
        }

        #content {
            margin-left: 220px;
            padding: 20px;
            background-color: white;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        #content h1, #content h2, #content h3 {
            color: #333;
        }

        #content hr {
            border: none;
            border-top: 1px solid #ddd;
            margin: 20px 0;
        }

        #rank-container {
            max-height: 400px;
            overflow-y: scroll;
            border: 1px solid #ddd;
            padding: 10px;
            margin-top: 20px;
            background-color: #f9f9f9;
            border-radius: 4px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 12px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
            cursor: pointer;
            position: sticky;
            top: 0;
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
        <li><a href="/SSO/student/otherRank.jsp">返回</a></li>
    </ul>
</div>

<div id="content">
    <h2>学生：${stu.s_name}</h2>
    <hr>
    <div id="class-info">
        <div class="info-item">
            <strong>排名：</strong> ${myClassRank}
        </div>
        <div class="info-item">
            <strong>班级：</strong> ${myClass.c_id}
        </div>
        <div class="info-item">
            <strong>学科：</strong> ${courseName1}
        </div>
        <div class="info-item">
            <strong>教室：</strong> ${myClass.c_room}
        </div>
        <div class="info-item">
            <strong>任课老师：</strong> ${myTeacher.t_name}
        </div>
        <div class="info-item">
            <strong>学期：</strong> ${myClass.c_time}
        </div>
    </div>
    <hr>
    <h3>排名信息</h3>
    <div id="rank-container">
        <table id="rankTable">
            <thead>
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>成绩</th>
                <th>排名</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${classRanks}" var="classRank">
                <tr>
                    <td>${classRank.s_id}</td>
                    <td>${classRank.s_name}</td>
                    <td>${classRank.finalGrade}</td>
                    <td>${classRank.rank}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
