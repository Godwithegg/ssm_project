<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge"> 
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Document</title>
    <script type="text/javascript">
        function queryItems()
        {
            document.itemsForm.action="${pageContext.request.contextPath }/crop/queryStatus.action";
            document.itemsForm.submit();
        }
        function editItems()
        {
            document.itemsForm.action="${pageContext.request.contextPath }/crop/editStatus.action"
            document.itemsForm.submit();
        }
    
    </script>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">    <!--navbar-fixed-bottom决定了顶部底部，固定的-->
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input name="statusCustom.name" class="form-control" placeholder="搜索">
            </div>
            <input type="button" class="btn" value="查询" onclick="queryItems()"/>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#">当前用户：${username }</a></li>
            <li class="dropdown">
                <c:if test="${username != null}">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/logout.action">退出登录</a>
                </c:if>
            </li>
        </ul>
    </nav>

    <form name="itemsForm" action="${pageContext.request.contextPath }/crop/queryStatus.action" method="post">
        <div class="panel panel-default">
            <div class="panel-heading">
                商品查询
            </div>
            <br>
            <table class="table">
                <thead>
                    <tr class="active">
                        <th>作物名称</th>
                        <th>温度</th>
                        <th>湿度</th>
                        <th>产量</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${statusList }" var="item">
                        <tr class="success">
                                <td>${item.name }</td>
                                <td>${item.temperature }</td>
                                <td>${item.moisture }</td>
                                <td>${item.production }</td>
                                <td><a href="${pageContext.request.contextPath }/crop/editStatus.action?id=${item.name}">修改</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </form>

</body>
</html>