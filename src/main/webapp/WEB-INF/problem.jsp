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


<div class="problem" style="width: 90%;margin: 30px auto;">
    <div class="panel panel-default">
        <!-- List group -->
        <div class="panel-heading" align="center"> ${problem.getProblemId()}   ${problem.getTitle()} </div>
        <div class="panel-body">
            <p>时间限制：${problem.getTime()}</p>
            <p>空间限制：${problem.getMem()}</p>
        </div>
        <div class="panel-heading" align="center"> 问题描述 </div>
        <div class="panel-body">
            <p>${problem.getDesc()}</p>
        </div>
        <div class="panel-heading" align="center"> 输入格式 </div>
        <div class="panel-body">
            <p>${problem.getInput()}</p>
        </div>
        <div class="panel-heading" align="center"> 输出格式 </div>
        <div class="panel-body">
            <p>${problem.getOutput()}</p>
        </div>
        <div class="panel-heading" align="center"> 输入样例 </div>
        <div class="panel-body">
            <p>${problem.getInputEx()}</p>
        </div>
        <div class="panel-heading" align="center"> 输出样例 </div>
        <div class="panel-body">
            <p>${problem.getOutputEx()}</p>
        </div>
        <div class="panel-heading" align="center"> 提示 </div>
        <div class="panel-body">
            <p>${problem.getTip()}</p>
        </div>
    </div>

    <form class="form-horizontal" action="/addsubmit"  method="post">
        <input type="hidden" name="problemId" value="${problem.getProblemId()}">
        <div align="center" style="margin: 30px">
        <p><span>选择使用的语言： </span>
                <select name="language" style="width: 200px">
                    <option value="1">C</option>
                    <option value="2">C++</option>
                    <option value="3">java</option>
                </select>
            </p>
        </div>
        <textarea name="source" id="source" style="width: 100%;height: 300px;"></textarea>

        <div class="form-group" style="width: 90%" align="center">
                <input type="submit" class="btn btn-primary" value="提交代码">
        </div>
    </form>


</div>
</body>
</html>