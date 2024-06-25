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
    <form method="post" action="/SSO/loginServlet" id="form">
        <h1 id="loginMsg">登录界面</h1>
        <div id="errorMsg" style="color:red;">${login_msg}</div>
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
            <a href="/SSO/register.jsp">没有账号？</a>
        </div>
    </form>
</div>
</body>
</html>
