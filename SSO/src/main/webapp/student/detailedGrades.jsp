<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>详细成绩</title>
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

        #content h1, #content h3 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
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
        }

        .button {
            padding: 5px 10px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div id="sidebar">
    <h1>学生</h1>
    <hr>
    <h3>功能列表</h3>
    <ul>
        <li><a href="/SSO/student/personGrade.jsp">返回成绩查看</a></li>
    </ul>
</div>

<div id="content">
    <h1>详细成绩 </h1>
    <table style="width: 60%;">
        <tr>
            <th>组成</th>
            <th>成绩</th>
        </tr>
        <tr>
            <td>平时成绩(10%)</td>
            <td>${param.usualGrade}</td>
        </tr>
        <tr>
            <td>期中成绩(20%)</td>
            <td>${param.midGrade}</td>
        </tr>
        <tr>
            <td>实验成绩(30%)</td>
            <td>${param.labGrade}</td>
        </tr>
        <tr>
            <td>考试成绩(40%)</td>
            <td>${param.examGrade}</td>
        </tr>

        <tr>
            <td>最终成绩</td>
            <td>${param.finalGrade}</td>
        </tr>
    </table>
</div>

</body>
</html>
