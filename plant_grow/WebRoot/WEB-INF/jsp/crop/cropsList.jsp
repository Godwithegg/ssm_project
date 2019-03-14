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
            document.itemsForm.action="${pageContext.request.contextPath }/crop/editStatus.action";
            document.itemsForm.submit();
        }
        function deleteItems()
        {
        	document.itemsForm.action="${pageContext.request.contextPath}/crop/deleteStatus.action";
        	document.itemsForm.submit();
        }
        function playItems()
        {
        	document.itemsForm.action="${pageContext.request.contextPath}/echarts/test.action";
        	document.itemsForm.submit();
        }
    
    </script>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">    <!--navbar-fixed-bottom决定了顶部底部，固定的-->
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
               <!-- <input name="statusCustom.name" class="form-control" placeholder="搜索"> -->
            </div>
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
        <div class="panel panel-default"><br/><br/>
            <div class="panel-heading">
                商品查询<input name="statusCustom.name" />
            <input type="button" class="btn-success" value="查询" onclick="queryItems()"/>
            <input type="button" class="btn-info" value="数据展示" onclick="playItems()">
            </div>
            <br>
            <table class="table">
                <thead>
                    <tr class="active">
                    	<th>选择</th>
                        <th>作物名称</th>
                        <th>温度</th>
                        <th>湿度</th>
                        <th>产量</th>
                        <th>修改</th>
                        <th>删除</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${statusList }" var="item">
                        <tr class="success">
                    	<td><input type="checkbox" name="id" value="${item.id}"></td>
                                <td>${item.name }</td>
                                <td>${item.temperature }</td>
                                <td>${item.moisture }</td>
                                <td>${item.production }</td>
                                <td><a href="${pageContext.request.contextPath }/crop/editStatus.action?id=${item.id}">修改</a></td>
                       			<td><input type="button" class="" value="删除" onclick="deleteItems()"></td>
                        
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </form>

</body>
</html>