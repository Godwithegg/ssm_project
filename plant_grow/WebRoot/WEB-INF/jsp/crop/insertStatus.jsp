<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html>
<html>
<head>
	<link rel="shortcut icon" href="img/fac.ico"/>
<link rel="bookmark" href="img/fac.ico"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<title>修改作物信息</title>
</head>
<style>
	body{background-color:#f8f8f8;}
</style>

<c:if test="${allErrors != null}">
	<c:forEach items="${allErrors }" var="error">
		${error.defaultMessage }<br/>
	</c:forEach>
</c:if>

<body> 
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">    <!--navbar-fixed-bottom决定了顶部底部，固定的-->
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#">当前用户：${username }</a></li>
            <li class="dropdown">
                <c:if test="${username != null}">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/logout.action">退出登录</a>
                </c:if>
            </li>
        </ul>
    </nav>
    <br/><br/><br/>

<form action="${pageContext.request.contextPath }/crop/insertStatusSubmit.action" method="post">

    <input type="hidden" name="id" value="${item.id}">
    <div class="text-primary col-sm-4">新增作物信息：</div>
    <div class="col-sm-12">
        <table class="table">
            <thead>
                
            </thead>
        <tbody>
       		<tr>
                <td>作物名称</td>
                <td>
                	<input type="text" name="name" value="${item.name }" required>
                </td>
              </tr>
            <tr>
                <td>温度</td>
                <td><input type="text" name="temperature" value="${item.temperature }" required></td>
            </tr>
            <tr>
                <td>湿度</td>
                <td><input type="text" name="moisture"  value="${item.moisture}" required></td>
            </tr>
 
            <tr>
                <td>产量</td>
                <td><input type="text" name="production" value="${item.production }" required></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="提交"/>
                </td>
            </tr>
        </tbody>
        </table>
    </div>
</form>
</body>

</html>