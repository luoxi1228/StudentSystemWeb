<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>添加班级</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
        }

        #sidebar {
            float: left;
            width: 200px;
            height: 100%;
            background-color: #007BFF;
            padding-top: 20px;
            position: fixed;
        }

        #sidebar h1 {
            text-align: center;
            color: white;
        }

        #sidebar h3 {
            text-align: center;
            color: white;
        }

        #sidebar hr {
            color: white;
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
            color: white;
            background-color: #0056b3;
            border-radius: 4px;
        }

        #sidebar ul li a:hover {
            background-color: #004494;
        }

        #content {
            margin-left: 220px;
            padding: 20px;
        }

        .form-container {
            max-width: 600px;
            margin: 0 auto;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
        }

        .form-group input,
        .form-group select {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
        }

        .button {
            padding: 10px 20px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            display: block;
            width: 100%;
            text-align: center;
        }

        .button:hover {
            background-color: #0056b3;
        }

        .error-message {
            color: red;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<div id="sidebar">
    <h1>班级管理</h1>
    <hr>
    <h3>功能选择</h3>
    <ul>
        <li><a href="/SSO/admin/classManageServlet">返回</a></li>
    </ul>
</div>
<div id="content">
    <div class="form-container">
        <h1>添加班级</h1>
        <hr>
        <c:if test="${not empty errorMessage}">
            <div class="error-message">${errorMessage}</div>
        </c:if>
        <form action="/SSO/admin/addClassServlet" method="post">
            <div class="form-group">
                <label for="classId">班级编号</label>
                <input type="text" id="classId" name="classId" value="${param.classId}" required>
            </div>
            <div class="form-group">
                <label for="teacherId">教师编号</label>
                <select id="teacherId" name="teacherId" required>
                    <option value="">请选择教师</option>
                    <c:forEach var="teacher" items="${allTeacher}">
                        <option value="${teacher.t_id}" <c:if test="${teacher.t_id == param.teacherId}">selected</c:if>>${teacher.t_id} - ${teacher.t_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="courseId">课程编号</label>
                <select id="courseId" name="courseId" required>
                    <option value="">请选择课程</option>
                    <c:forEach var="course" items="${allCourse}">
                        <option value="${course.co_id}" <c:if test="${course.co_id == param.courseId}">selected</c:if>>${course.co_id} - ${course.co_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="classRoom">教室</label>
                <input type="text" id="classRoom" name="classRoom" value="${param.classRoom}" required>
            </div>
            <div class="form-group">
                <label for="term">学期</label>
                <input type="text" id="term" name="term" value="${param.term}" required>
            </div>
            <button type="submit" class="button">添加班级</button>
        </form>
    </div>
</div>
</body>
</html>
