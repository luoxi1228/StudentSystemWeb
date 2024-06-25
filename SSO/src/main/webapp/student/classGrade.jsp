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
    <title>班级成绩</title>
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

        #content h1, #content h2, #content h3 {
            color: #333;
        }

        #grade-container {
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
    </style>
    <script>
        let sortDirections = [true, true, true]; // 初始排序方向为升序
        let currentColumn = -1; // 当前排序的列，初始值为-1表示没有排序

        function sortTable(columnIndex) {
            var table, rows, switching, i, x, y, shouldSwitch, dir, switchCount = 0;
            table = document.getElementById("gradesTable");
            switching = true;
            dir = sortDirections[columnIndex] ? "asc" : "desc"; // 根据当前排序方向设置

            while (switching) {
                switching = false;
                rows = table.rows;
                for (i = 1; i < (rows.length - 1); i++) {
                    shouldSwitch = false;
                    x = rows[i].getElementsByTagName("TD")[columnIndex];
                    y = rows[i + 1].getElementsByTagName("TD")[columnIndex];
                    if (dir == "asc") {
                        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                            shouldSwitch = true;
                            break;
                        }
                    } else if (dir == "desc") {
                        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                            shouldSwitch = true;
                            break;
                        }
                    }
                }
                if (shouldSwitch) {
                    rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                    switching = true;
                    switchCount++;
                } else {
                    if (switchCount == 0 && dir == "asc") {
                        dir = "desc";
                        switching = true;
                    }
                }
            }

            sortDirections[columnIndex] = !sortDirections[columnIndex]; // 切换排序方向
            currentColumn = columnIndex; // 更新当前排序的列
            updateSortIcons();
        }

        function updateSortIcons() {
            let headers = document.querySelectorAll("#gradesTable th");
            headers.forEach((header, index) => {
                let icon = header.querySelector(".sort-icon");
                if (index === currentColumn) {
                    if (sortDirections[index]) {
                        icon.classList.remove("fa-sort-down");
                        icon.classList.add("fa-sort-up");
                    } else {
                        icon.classList.remove("fa-sort-up");
                        icon.classList.add("fa-sort-down");
                    }
                } else {
                    icon.classList.remove("fa-sort-up", "fa-sort-down");
                    icon.classList.add("fa-sort");
                }
            });
        }
    </script>
</head>
<body>
<div id="sidebar">
    <h1>学生</h1>
    <hr>
    <h3>功能选择</h3>
    <ul>
        <li><a href="/SSO/student/personGrade.jsp">返回成绩查看</a></li>
    </ul>
</div>

<div id="content">
    <h1>班级：${classId}</h1>
    <div id="classInfo">
        <table>
            <tr>
                <th>科目</th>
                <th>教室</th>
                <th>老师</th>
                <th>时间</th>
            </tr>
            <tr>
                <td>${classCourse}</td>
                <td>${classRoom}</td>
                <td>${classTeacher}</td>
                <td>${classTime}</td>
            </tr>
        </table>
    </div>

    <h3>成绩信息</h3>
    <div id="grade-container">
        <table id="gradesTable">
            <tr>
                <th onclick="sortTable(0)">学号 <i class="fas fa-sort sort-icon"></i></th>
                <th onclick="sortTable(1)">姓名 <i class="fas fa-sort sort-icon"></i></th>
                <th onclick="sortTable(2)">成绩 <i class="fas fa-sort sort-icon"></i></th>
            </tr>
            <c:forEach items="${classGrades}" var="classGrade">
                <tr>
                    <td>${classGrade.s_id}</td>
                    <td>${classGrade.s_name}</td>
                    <td>${classGrade.finalGrade}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
