<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/5/22
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>班级信息</title>
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
    <script>
        function viewClassGrades(c_id) {
            window.location.href = '/SSO/teacher/changeGradeServlet?c_id=' + c_id;
        }
    </script>
</head>
<body>
<div id="sidebar">
    <h1>教师</h1>
    <hr>
    <h3>功能选择</h3>
    <ul>
        <li><a href="/SSO/teacher/teacherHome.jsp">返回个人信息</a></li>
    </ul>
</div>

<div id="content">
    <h1>用户：${tea.t_name}</h1>
    <hr>
    <h3>上课班级如下</h3>
    <table>
        <tr>
            <th>班级编号</th>
            <th>教室</th>
            <th>学生人数</th>
            <th>学期</th>
        </tr>
        <c:forEach items="${Teaclassrooms}" var="Teaclassrooms">
            <tr>
                <td>${Teaclassrooms.c_id}</td>
                <td>${Teaclassrooms.c_room}</td>
                <td>${Teaclassrooms.s_num}</td>
                <td>${Teaclassrooms.c_time}</td>
                <td>
                    <button class="button" onclick="viewClassGrades('<c:out value="${Teaclassrooms.c_id}"/>')">更改成绩</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
