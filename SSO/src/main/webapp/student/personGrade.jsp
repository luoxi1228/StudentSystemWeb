<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人成绩</title>
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
    <script>
        function viewClassGrades(c_id) {
            window.location.href = '/SSO/student/classGradeServlet?c_id=' + c_id;
        }

        function viewDetailedGrades(co_name, midGrade, labGrade, examGrade, usualGrade, finalGrade) {
            var form = document.createElement("form");
            form.method = "POST";
            form.action = "/SSO/student/detailedGrades.jsp";

            var addField = function(name, value) {
                var input = document.createElement("input");
                input.type = "hidden";
                input.name = name;
                input.value = value;
                form.appendChild(input);
            };

            addField("co_name", co_name);
            addField("midGrade", midGrade);
            addField("labGrade", labGrade);
            addField("examGrade", examGrade);
            addField("usualGrade", usualGrade);
            addField("finalGrade", finalGrade);

            document.body.appendChild(form);
            form.submit();
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
    <h1>用户：${stu.s_name}</h1>
    <h3>各科成绩如下</h3>
    <table>
        <tr>
            <th>科目</th>
            <th>成绩</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${personGrade}" var="persongrade">
            <tr>
                <td><c:out value="${persongrade.co_name}"/></td>
                <td><c:out value="${persongrade.finalGrade}"/>分</td>
                <td>
                    <button class="button"
                            onclick="viewDetailedGrades(
                                    '${persongrade.co_name}',
                                    '${persongrade.midGrade}',
                                    '${persongrade.labGrade}',
                                    '${persongrade.examGrade}',
                                    '${persongrade.usualGrade}',
                                    '${persongrade.finalGrade}'
                                    )">查看详细</button>
                    <button class="button" onclick="viewClassGrades('<c:out value="${persongrade.c_id}"/>')">查看班级成绩</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
