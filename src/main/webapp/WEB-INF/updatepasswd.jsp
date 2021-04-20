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

<div class="personal" style="width: 50%;margin: 30px auto;">

<form class="form-horizontal" action="/updateuserpassword"  method="post">
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">新密码</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" name="password" id="password">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" class="btn btn-default" value="修改密码">
        </div>
    </div>
</form>
</div>
</body>
</html>