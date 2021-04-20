<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>submitlist .jsp</title>
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>


<div class="submitList" style="width: 90%;margin: 30px auto;">
    <!-- 学号搜索 -->
    <form class="form-inline"  action="/searchuserid"  method="get" style="margin-bottom: 10px">
        <div class="form-group">
            <label for="userId"></label>
            <input type="text" class="form-control" name="userId" id="userId" placeholder="要查找的学号">
        </div>
        <input type="submit" class="btn btn-default" value="搜索">
    </form>
    <div class="panel panel-default">
        <!-- List group -->
        <div class="panel-heading" align="center">提交记录</div>
        <table class="table table-hover">
            <tr align="center">
                <th style="width: 2%"></th>
                <th style="width: 5%">运行号</th>
                <th style="width: 8%">用户名</th>
                <th style="width: 10%">学号</th>
                <th style="width: 7%">题号</th>
                <th style="width: 20%">标题</th>
                <th style="width: 8%">语言</th>
                <th style="width: 18%">结果</th>
                <th style="width: 5%">用时</th>
                <th style="width: 10%">内存</th>
            </tr>
            <c:forEach items="${pageInfo.getList() }" var="s">
                <tr>
                    <td></td>
                    <td>${s.getSubmitId()}</td>
                    <td>${s.getUsername()}</td>
                    <td>${s.getUserId()}</td>
                    <td><a target="mainview" href="/problem/${s.getProblemId()}">${s.getProblemId()}</a></td>
                    <td><a target="mainview" href="/problem/${s.getProblemId()}">${s.getProblemTitle()}</a></td>
                    <td>${s.getLanguageName()}</td>
                    <td>${s.getResult()}</td>
                    <td>${s.getUsedTime()}s</td>
                    <td>${s.getUsedMem()}kb</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="row">
        <div id="show_page_info" class="col-md-4" style="line-height: 80px;">
        </div>
        <div id="show_page_nav" class="col-md-8 text-right">
            <ul class="pagination" id="pagination">
                <li><a target="mainview" href="/submits">首页</a></li>
                <li><a target="mainview" href="/submits?page=${pageInfo.getPageNum()-1}">上一页</a></li>
                <li><a target="mainview" href="/submits?page=${pageInfo.getPageNum()+1}">下一页</a>
                <li><a target="mainview" href="/submits?page=${pageInfo.getPageSize()}">末页</a>
            </ul>
            </nav>
        </div>
    </div>

</div>
</body>
</html>