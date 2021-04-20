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

<div class="admin_adddatafile" style="width: 50%;margin: 30px auto;">

<form  class="form-horizontal" action='/addproblemsdata' method='post' enctype='multipart/form-data'>
    <input type="hidden" name="problemId" value="${problemId}">

    <div class="form-group">
        <label for="exampleInputFile">数据文件</label>
        <input type="file" id="exampleInputFile" name="file">
        <p class="help-block">上传题号命名的压缩文件.</p>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" class="btn btn-default" value="上传">
        </div>
    </div>
</form>
</div>
</body>
</html>