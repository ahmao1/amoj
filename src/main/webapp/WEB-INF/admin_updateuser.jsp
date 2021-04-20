<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="admin_updateuser" style="width: 50%;margin: 30px auto;">

    <form class="form-horizontal" action="/updateuser"  method="post">
        <div class="form-group">
            <label class="col-sm-2 control-label">学号</label>
            <div class="col-sm-10">
                <p class="form-control-static">${user.getUserId()}</p>
            </div>
        </div>
        <input type="hidden" name="userId" value="${user.getUserId()}">
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="username" id="username" value="${user.getUsername()}">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-default" value="提交">
            </div>
        </div>
    </form>
</div>
</body>
</html>