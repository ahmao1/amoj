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

<div class="admin_addproblem" style="width: 50%;margin: 30px auto;">

    <form class="form-horizontal" action="/addproblem"  method="post">
        <div class="form-group">
            <label for="problemId" class="col-sm-2 control-label">题号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="problemId" id="problemId" value="${lastId}">
            </div>
        </div>
        <div class="form-group">
            <label for="title" class="col-sm-2 control-label">标题</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="title" id="title">
            </div>s
        </div>
        <input type="hidden" name="submit" value="0">
        <input type="hidden" name="solve" value="0">
        <div class="form-group">
            <label for="time" class="col-sm-2 control-label">时间限制s</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="time" id="time">
            </div>
        </div>
        <div class="form-group">
            <label for="mem" class="col-sm-2 control-label">内存限制kb</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="mem" id="mem">
            </div>
        </div>
        <div class="form-group">
            <label for="desc" class="col-sm-2 control-label">描述</label>
            <div class="col-sm-10">
                <textarea  class="form-control" name="desc" id="desc" style="width: 100%;height: 150px;" ></textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="input" class="col-sm-2 control-label">输入</label>
            <div class="col-sm-10">
                <textarea class="form-control"  name="input" id="input" style="width: 100%;height: 100px;" ></textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="output" class="col-sm-2 control-label">输出</label>
            <div class="col-sm-10">
                <textarea class="form-control"  name="output" id="output" style="width: 100%;height: 100px;" ></textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="inputEx" class="col-sm-2 control-label">输入样例</label>
            <div class="col-sm-10">
                <textarea class="form-control"  name="inputEx" id="inputEx" style="width: 100%;height: 100px;" ></textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="outputEx" class="col-sm-2 control-label">输出样例</label>
            <div class="col-sm-10">
                <textarea class="form-control"  name="outputEx" id="outputEx" style="width: 100%;height: 100px;" ></textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="tip" class="col-sm-2 control-label">提示</label>
            <div class="col-sm-10">
                <textarea class="form-control"  name="tip" id="tip" style="width: 100%;height: 100px;" ></textarea>
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