<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>修改成绩</title>
    <style>
        /* 样式代码 */
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
        #sidebar hr {
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
            position: relative;
        }

        #content h1, #content h3 {
            color: #333;
        }

        .table-container {
            max-height: 400px; /* 设置容器的最大高度 */
            overflow-y: auto; /* 使容器内容可垂直滚动 */
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
        }

        .button {
            padding: 10px 20px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            position: absolute;
            bottom: -50px;
            right: 50px;
        }

        .button:hover {
            background-color: #0056b3;
        }

        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgb(0,0,0);
            background-color: rgba(0,0,0,0.4);
        }

        .modal-content {
            background-color: #fefefe;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 30%;
            text-align: center;
        }

        .close-button {
            padding: 5px 10px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .close-button:hover {
            background-color: #0056b3;
        }
    </style>
    <script>
        function updateFinalGrade(row) {
            let midGrade = parseFloat(row.cells[2].children[0].value);
            let labGrade = parseFloat(row.cells[3].children[0].value);
            let examGrade = parseFloat(row.cells[4].children[0].value);
            let usualGrade = parseFloat(row.cells[5].children[0].value);
            let finalGrade = Math.round(midGrade * 0.2 + labGrade * 0.3 + examGrade * 0.4 + usualGrade * 0.1);
            row.cells[6].innerText = finalGrade;
        }

        function submitGrades() {
            let table = document.getElementById("gradesTable");
            let grades = [];

            for (let i = 1; i < table.rows.length; i++) {
                let row = table.rows[i];
                let midGrade = parseFloat(row.cells[2].children[0].value);
                let labGrade = parseFloat(row.cells[3].children[0].value);
                let examGrade = parseFloat(row.cells[4].children[0].value);
                let usualGrade = parseFloat(row.cells[5].children[0].value);
                let finalGrade = Math.round(midGrade * 0.2 + labGrade * 0.3 + examGrade * 0.4 + usualGrade * 0.1);

                let grade = {
                    s_id: row.cells[0].innerText,
                    c_id: row.cells[1].getAttribute('data-cid'), // 获取隐藏的c_id属性
                    midGrade: midGrade,
                    labGrade: labGrade,
                    examGrade: examGrade,
                    usualGrade: usualGrade,
                    finalGrade: finalGrade
                };

                grades.push(grade);
            }

            fetch('/SSO/teacher/updateGradesServlet', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(grades)
            }).then(response => {
                if (response.ok) {
                    showModal();
                } else {
                    console.error('Failed to update grades');
                }
            });
            console.log(JSON.stringify(grades));
        }

        function showModal() {
            let modal = document.getElementById("successModal");
            modal.style.display = "block";
        }

        function closeModal() {
            let modal = document.getElementById("successModal");
            modal.style.display = "none";
        }

        document.addEventListener('DOMContentLoaded', (event) => {
            let table = document.getElementById("gradesTable");

            for (let i = 1; i < table.rows.length; i++) {
                let row = table.rows[i];
                let inputs = row.getElementsByTagName('input');

                for (let input of inputs) {
                    input.addEventListener('input', () => updateFinalGrade(row));
                }
            }
        });
    </script>
</head>
<body>
<div id="sidebar">
    <h1>教师</h1>
    <hr>
    <h3>功能选择</h3>
    <ul>
        <li><a href="/SSO/teacher/classInfo.jsp">返回</a></li>
    </ul>
</div>

<div id="content">
    <h1>班级:${class_id}</h1>
    <div class="table-container">
        <table id="gradesTable">
            <tr>
                <th>学生学号</th>
                <th>学生姓名</th>
                <th>期中成绩</th>
                <th>实验成绩</th>
                <th>考试成绩</th>
                <th>平时成绩</th>
                <th>最终成绩</th>
            </tr>
            <c:forEach var="grade" items="${TeaGrades}">
                <tr>
                    <td>${grade.s_id}</td>
                    <td data-cid="${grade.c_id}">${grade.s_name}</td>
                    <td><input type="number" value="${grade.midGrade}" /></td>
                    <td><input type="number" value="${grade.labGrade}" /></td>
                    <td><input type="number" value="${grade.examGrade}" /></td>
                    <td><input type="number" value="${grade.usualGrade}" /></td>
                    <td>${grade.finalGrade}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <button class="button" onclick="submitGrades()">提交修改</button>
</div>

<div id="successModal" class="modal">
    <div class="modal-content">
        <p>修改成功！</p>
        <button class="close-button" onclick="closeModal()">确认</button>
    </div>
</div>
</body>
</html>
