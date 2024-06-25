<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>选课</title>
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

        /* 弹窗样式 */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgb(0, 0, 0);
            background-color: rgba(0, 0, 0, 0.4);
            padding-top: 60px;
        }

        .modal-content {
            background-color: #fefefe;
            margin: 5% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
    </style>
    <script>
        function closeModal() {
            var modal = document.getElementById("myModal");
            modal.style.display = "none";
        }

        window.onclick = function (event) {
            var modal = document.getElementById("myModal");
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }

        function viewClassGrades(co_id) {
            window.location.href = '/SSO/student/subjectRankServlet?co_id=' + co_id;
        }

        function viewClassGrades1(c_id) {
            window.location.href = '/SSO/student/classRankServlet?c_id=' + c_id;
        }
    </script>
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
    <h2>学生：${stu.s_name}</h2>
    <hr>

    <!-- 显示已选科目 -->
    <div id="selectedCourses">
        <h3>已选科目如下</h3>
        <table>
            <tr>
                <th>科目</th>
            </tr>
            <c:forEach items="${hasSelectCourse}" var="hasSelectCourseItem">
                <tr>
                    <td>${hasSelectCourseItem.co_name}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <!-- 显示可选科目 -->
    <div id="availableCourses">
        <h3>可选科目如下</h3>
        <table>
            <tr>
                <th>科目</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${notSelectCourse}" var="notSelectCourseItem">
                <tr>
                    <td>${notSelectCourseItem.co_name}</td>
                    <td>
                        <!-- 添加选课按钮 -->
                        <form action="/SSO/student/courseSelectServlet01" method="post">
                            <input type="hidden" name="courseId" value="${notSelectCourseItem.co_id}"/>
                            <input type="hidden" name="courseName" value="${notSelectCourseItem.co_name}"/>
                            <button type="submit" class="button">选课</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
