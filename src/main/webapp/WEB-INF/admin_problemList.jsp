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


<div class="problemList" style="width: 90%;margin: 30px auto;">
    <!-- 标题模糊搜索 -->
    <form class="form-inline"  action="/searchtitle"  method="get" style="margin-bottom: 10px">
        <div class="form-group">
            <label for="titleword"></label>
            <input type="text" class="form-control" name="titleword" id="titleword" placeholder="要查找的标题">
        </div>
        <input type="submit" class="btn btn-default" value="搜索">
    </form>

    <a class="btn btn-success" style="margin-top: -75px; margin-left: 300px;"
       target="mainview" href="/addproblemframe" role="button">添加题目</a>

    <div class="panel panel-default">

        <div class="panel-heading" align="center">题库管理</div>
        <table class="table table-hover" valign="middle">
            <tr align="center" valign="middle">
                <th style="width: 5%"></th>
                <th style="width: 10%">题号</th>
                <th style="width: 50%">标题</th>
                <th style="width: 10%">提交次数</th>
                <th style="width: 10%">通过次数</th>
                <th style="width: 20%">操作</th>
            </tr>
            <c:forEach items="${pageInfo.getList() }" var="p">
                <tr>
                    <td valign="middle"></td>
                    <td valign="middle">${p.getProblemId()}</td>
                    <td valign="middle"><a target="mainview" href="/problem/${p.getProblemId()}">${p.getTitle()}</a></td>
                    <td valign="middle">${p.getSubmit()}</td>
                    <td valign="middle">${p.getSolve()}</td>
                    <td valign="middle">
                        <a class="btn btn-info btn-xs"
                           target="mainview" href="/updateproblem?pid=${p.getProblemId()}" role="button">修改</a>
                        <a class="btn btn-danger btn-xs"
                           target="mainview" href="/deleteproblems?id=${p.getProblemId()}" role="button">删除</a>
                        <a class="btn btn-success btn-xs"
                           target="mainview" href="/adddatafileframe?id=${p.getProblemId()}" role="button">上传数据</a>
                    </td>

                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="row">
        <div id="show_page_info" class="col-md-4" style="line-height: 80px;">
        </div>
        <div id="show_page_nav" class="col-md-8 text-right">
            <ul class="pagination" id="pagination">
                <li><a target="mainview" href="/adminproblems">首页</a></li>
                <li><a target="mainview" href="/adminproblems?page=${pageInfo.getPageNum()-1}">上一页</a></li>
                <li><a target="mainview" href="/adminproblems?page=${pageInfo.getPageNum()+1}">下一页</a>
                <li><a target="mainview" href="/adminproblems?page=${pageInfo.getPageSize()}">末页</a>
            </ul>
            </nav>
        </div>
    </div>

</div>
</body>
</html>