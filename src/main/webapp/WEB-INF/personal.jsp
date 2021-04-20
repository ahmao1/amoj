<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>


    <div class="personal" style="width: 90%;margin: 30px auto;">
        <div class="panel panel-default">
            <!-- List group -->
            <div class="panel-heading" align="center">个人资料</div>

            <ul class="list-group">
                <li class="list-group-item">用户名：${user.getUsername()}</li>
                <li class="list-group-item">学号：${user.getUserId()}</li>
                <li class="list-group-item">提交次数：${user.getSubmit()}</li>
                <li class="list-group-item">已解决问题：
                    <c:forEach items="${solve}" var="s">
                        <a target="mainview" href="/problem/${s}">${s}</a>&nbsp;
                    </c:forEach>
                </li>
                <li class="list-group-item">提交未解决问题：
                    <c:forEach items="${unsolve}" var="s">
                        <a target="mainview" href="/problem/${s}">${s}</a>&nbsp;
                    </c:forEach>
                </li>
            </ul>
        </div>
        <a class="btn btn-info" target="mainview" href="/updatepasswd"  role="button">修改密码</a>
        <a class="btn btn-info" target="mainview" href="/updateusername"  role="button">修改用户名</a>
    </div>
</body>
</html>