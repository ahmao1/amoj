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
    <div class="panel panel-default">

        <div class="panel-heading" align="center">题库</div>
        <table class="table table-hover">
            <tr align="center">
                <th style="width: 5%"></th>
                <th style="width: 10%">题号</th>
                <th style="width: 50%">标题</th>
                <th style="width: 10%">提交次数</th>
                <th style="width: 10%">通过次数</th>
            </tr>
            <c:forEach items="${pageInfo.getList() }" var="p">
                <tr>
                    <td></td>
                <td>${p.getProblemId()}</td>
                <td><a target="mainview" href="/problem/${p.getProblemId()}">${p.getTitle()}</a></td>
                <td>${p.getSubmit()}</td>
                <td>${p.getSolve()}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <div class="row">
        <div id="show_page_info" class="col-md-4" style="line-height: 80px;">
        </div>
        <div id="show_page_nav" class="col-md-8 text-right">
            <ul class="pagination" id="pagination">
                <li><a target="mainview" href="/problems">首页</a></li>
                <li><a target="mainview" href="/problems?page=${pageInfo.getPageNum()-1}">上一页</a></li>
                <li><a target="mainview" href="/problems?page=${pageInfo.getPageNum()+1}">下一页</a>
                <li><a target="mainview" href="/problems?page=${pageInfo.getPageSize()}">末页</a>
            </ul>
            </nav>
        </div>
    </div>

</div>
</body>
</html>