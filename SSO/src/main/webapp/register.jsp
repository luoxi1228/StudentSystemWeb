<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>注册页面</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
    <script>
        function toggleForm() {
            var role = document.getElementById('role').value;
            if (role === 'student') {
                document.getElementById('studentSpecific').style.display = 'block';
                document.getElementById('teacherSpecific').style.display = 'none';
            } else {
                document.getElementById('studentSpecific').style.display = 'none';
                document.getElementById('teacherSpecific').style.display = 'block';
            }
        }

        window.onload = function() {
            toggleForm(); // Set initial form based on the default selection
        };

        function validateForm() {
            var account = document.getElementById('account').value;
            var errorMsg = document.getElementById('errorMsg');
            var studentPattern = /^S_2021\d{4}$/;
            var teacherPattern = /^T_2021\d{4}$/;

            if (!studentPattern.test(account) && !teacherPattern.test(account)) {
                errorMsg.innerText = "账号格式必须为 S_2021xxxx 或 T_2021xxxx";
                return false; // 阻止表单提交
            }

            errorMsg.innerText = ""; // 清除错误信息
            return true; // 允许表单提交
        }
    </script>
</head>
<body>
<div id="registerDiv">
    <h1>用户注册</h1>
    <!-- 显示提示信息 -->
    <div id="errorMsg" style="color:red;">${register_msg}</div>
    <form action="/SSO/registerServlet" method="post" onsubmit="return validateForm()">
        <label for="role">请选择角色：</label>
        <select id="role" name="role" onchange="toggleForm()">
            <option value="student">学生</option>
            <option value="teacher">老师</option>
        </select>

        <div id="commonFields">
            <%--@declare id="gender"--%><label for="account">账号：</label>
            <input type="text" id="account" name="account" class="inputField"><br>

            <label for="name">姓名：</label>
            <input type="text" id="name" name="name" class="inputField"><br>

            <label for="gender">性别：</label>
            <input type="radio" id="male" name="gender" value="男">
            <label for="male">男</label>
            <input type="radio" id="female" name="gender" value="女">
            <label for="female">女</label><br>

            <label for="age">年龄：</label>
            <input type="number" id="age" name="age" class="inputField"><br>

            <label for="faculty">学院：</label>
            <select id="faculty" name="faculty" class="inputField">
                <option value="计算机学院">计算机学院</option>
                <option value="电气学院">电气学院</option>
                <option value="通信学院">通信学院</option>
                <option value="自动化学院">自动化学院</option>
                <option value="光电学院">光电学院</option>
            </select><br>

            <label for="password">密码：</label>
            <input type="password" id="password" name="password" class="inputField"><br>
        </div>

        <div id="buttonContainer">
            <input type="submit" value="注册" class="button">
            <a href="/SSO/login.jsp" id="loginLink">返回登录</a>
        </div>
    </form>
</div>
</body>
</html>
