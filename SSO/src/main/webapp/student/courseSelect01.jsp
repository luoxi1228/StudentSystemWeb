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
            width: 50%;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
            align-self: flex-end;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }

        .modal p {
            text-align: center;
            margin-bottom: 20px;
        }
    </style>
    <script>
        function closeModal() {
            var modal = document.getElementById("successModal");
            modal.style.display = "none";
        }

        function showSuccessModal() {
            var modal = document.getElementById("successModal");
            modal.style.display = "block";
        }

        function debugForm(event) {
            event.preventDefault();
            const form = event.target;
            const classId = form.querySelector('input[name="classId"]').value;
            console.log('classId:', classId);
            form.submit();
            showSuccessModal();
        }

        window.onclick = function (event) {
            var modal = document.getElementById("successModal");
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    </script>
</head>
<body>
<div id="sidebar">
    <h1>学生</h1>
    <hr>
    <h3>功能选择</h3>
    <ul>
        <li><a href="/SSO/student/courseSelect.jsp">返回选课</a></li>
    </ul>
</div>
<div id="content">
    <h2>学生：${stu.s_name}</h2>
    <h3>学科：${courseName}</h3>
    <hr>
    <!-- 班级信息 -->
    <div id="availableCourses">
        <h3>可选班级</h3>
        <table>
            <tr>
                <th>可选班级</th>
                <th>教室</th>
                <th>老师</th>
                <th>学期</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${classInfo}" var="classInfoItem">
                <tr>
                    <td>${classInfoItem.c_id}</td>
                    <td>${classInfoItem.c_room}</td>
                    <td>${classInfoItem.t_name}</td>
                    <td>${classInfoItem.c_time}</td>
                    <td>
                        <!-- 添加选课按钮 -->
                        <form action="/SSO/student/selectSuccessfulServlet" method="post" onsubmit="debugForm(event)">
                            <input type="hidden" name="studentId" value="${stu.s_id}"/>
                            <input type="hidden" name="classId" value="${classInfoItem.c_id}"/>
                            <button type="submit" class="button">确认选课</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<!-- 成功弹窗 -->
<div id="successModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal()">&times;</span>
        <p>选课成功！</p>
        <button onclick="closeModal()" class="button">确定</button>
    </div>
</div>
</body>
</html>
