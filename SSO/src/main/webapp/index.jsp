<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <form action="/SSO/loginServlet" method="post" id="form">
        <h1 id="loginMsg">登录界面</h1>
        <div id="errorMsg">${login_msg} ${register_msg}</div>
        <p>用户:<input id="username" name="username" type="text"></p>
        <p>密码:<input id="password" name="password" type="password"></p>
        <p>账号类型:
            <select id="accountType" name="accountType">
                <option value="student">学生</option>
                <option value="teacher">老师</option>
                <option value="admin">管理员</option>
            </select>
        </p>
        <div id="subDiv">
            <input type="submit" class="button" value="登录">
            <input type="reset" class="button" value="重置">&nbsp;&nbsp;&nbsp;
            <a href="register.jsp">没有账号？</a>
        </div>
    </form>
</div>

<script>
    document.getElementById('form').addEventListener('submit', function () {
        var accountType = document.getElementById('accountType').value;
        var action = '/SSO/';

        if (accountType === 'student') {
            action += 'studentLoginServlet'; // 学生登录 Servlet 的路径
        } else if (accountType === 'teacher') {
            action += 'teacherLoginServlet'; // 老师登录 Servlet 的路径
        } else if (accountType === 'admin') {
            action += 'admin/adminLoginServlet'; // 管理员登录 Servlet 的路径
        }

        this.action = action;
    });
</script>

</body>
</html>