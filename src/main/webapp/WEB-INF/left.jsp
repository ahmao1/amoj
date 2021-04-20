<%--
  Created by IntelliJ IDEA.
  User: TR
  Date: 2021/4/18
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>left.jsp</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<ul class="nav nav-pills nav-justified  ">
    <li role="presentation"><a target="mainview" href="/user/${currentUserId}">个人中心</a></li>
    <li role="presentation"><a target="mainview" href="/problems">题库</a></li>
    <li role="presentation"><a target="mainview" href="/submits">状态</a></li>
</ul>
</body>
</html>
