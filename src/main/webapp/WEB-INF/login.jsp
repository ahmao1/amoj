<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login.jsp</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body style="background-color: #fff6f6;">
<div class="page-header" style="background-color: #fff6f6; color: #514f4f;">
    <h1  style="margin-left: 650px">amoj <small>校园在线评测系统</small></h1>
</div>
<ul class="nav nav-pills nav-justified  ">
    <li role="presentation"><a href="/amoj">登录</a></li>
    <li role="presentation"><a href="/regist">注册</a></li>
</ul>
<div style="margin:50px auto;width: 50%;">
    <form class="form-horizontal" action="/amoj-index"  method="post">
        <div class="form-group">
            <label for="userId" class="col-sm-2 control-label">学号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="userId" id="userId">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" name="password" id="password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-default" value="登录">
            </div>
        </div>
    </form>
</div>
</body>
</html>