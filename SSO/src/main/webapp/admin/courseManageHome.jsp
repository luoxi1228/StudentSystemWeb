<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/5/23
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>课程管理</title>
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

        #sidebar h3 {
            text-align: center;
            color: white; /* 标题文字颜色 */
        }

        #sidebar hr {
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

        #content h2 {
            border-bottom: 2px solid #ccc;
            padding-bottom: 10px;
        }

        #content p {
            font-size: 18px;
            line-height: 1.6;
        }

        .button {
            padding: 10px 20px; /* 增大按钮大小 */
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .button:hover {
            background-color: #0056b3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table, th, td {
            border: 1px solid #ccc;
        }

        th, td {
            padding: 10px;
            text-align: center;
        }

        #classTableWrapper {
            max-height: 400px;
            overflow-y: scroll;
            margin-bottom: 40px; /* 增加底部间距 */
        }

        .button-container {
            text-align: center;
            margin-top: 40px; /* 增加顶部间距 */
        }
    </style>
    <script>
        function viewClassGrades() {
            window.location.href = '/SSO/admin/addCourseServlet';
        }
    </script>
</head>
<body>
<div id="sidebar">
    <h1>课程管理</h1>
    <hr>
    <h3>功能选择</h3>
    <ul>
        <li><a href="/SSO/admin/adminHome.jsp">返回</a></li>
    </ul>
</div>
<div id="content">
    <h1>用户：${admin.account}</h1>
    <hr>
    <h3>课程信息</h3>
    <div id="classTableWrapper">
        <table>
            <tr>
                <th>课程id</th>
                <th>课程名称</th>
            </tr>
            <c:forEach items="${manageCourse}" var="manageCourse">
                <tr>
                    <td>${manageCourse.co_id}</td>
                    <td>${manageCourse.co_name}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="button-container">
        <button class="button" onclick="viewClassGrades()">添加课程</button>
    </div>
</div>
</body>
</html>

