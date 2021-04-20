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


<div class="userList" style="width: 90%;margin: 30px auto;">
    <!-- 标题模糊搜索 -->
    <form class="form-inline"  action="/searchuserbyuserid"  method="get" style="margin-bottom: 10px">
        <div class="form-group">
            <label for="userId"></label>
            <input type="text" class="form-control" name="userId" id="userId" placeholder="要查找的学号">
        </div>
        <input type="submit" class="btn btn-default" value="搜索">
    </form>
    <div class="panel panel-default">

        <div class="panel-heading" align="center">用户管理</div>
        <table class="table table-hover" valign="middle">
            <tr align="center" valign="middle">
                <th style="width: 5%"></th>
                <th style="width: 10%">学号</th>
                <th style="width: 50%">用户名</th>
                <th style="width: 10%">提交次数</th>
                <th style="width: 10%">解决题数</th>
                <th style="width: 20%">操作</th>
            </tr>
            <c:forEach items="${pageInfo.getList() }" var="u">
                <tr>
                    <td valign="middle"></td>
                    <td valign="middle">${u.getUserId()}</td>
                    <td valign="middle"><a target="mainview" href="/user/${u.getUserId()}">${u.getUsername()}</a></td>
                    <td valign="middle">${u.getSubmit()}</td>
                    <td valign="middle">${u.getSolveNumber()}</td>
                    <td valign="middle">
                        <a class="btn btn-info btn-xs"
                           target="mainview" href="/updateuser?uid=${u.getUserId()}" role="button">修改</a>
                        <a class="btn btn-danger btn-xs"
                           target="mainview" href="/deleteuser?id=${u.getUserId()}" role="button">删除</a>
                        <a class="btn btn-success btn-xs"
                           target="mainview" href="/remakepasswd?id=${u.getUserId()}" role="button">重置密码</a>
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
                <li><a target="mainview" href="/adminusers">首页</a></li>
                <li><a target="mainview" href="/adminusers?page=${pageInfo.getPageNum()-1}">上一页</a></li>
                <li><a target="mainview" href="/adminusers?page=${pageInfo.getPageNum()+1}">下一页</a>
                <li><a target="mainview" href="/adminusers?page=${pageInfo.getPageSize()}">末页</a>
            </ul>
            </nav>
        </div>
    </div>

</div>
</body>
</html>