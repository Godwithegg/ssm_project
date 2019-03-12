<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<title>查询作物列表</title>
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

<form action="${pageContext.request.contextPath }/crop/editStatusSubmit.action" method="post" enctype="multipart/form-data">

    <input type="hidden" name="name" value="${statusCustom.name}">
    <div class="text-primary col-sm-4">修改作物信息：</div>
    <div class="col-sm-12">
        <table class="table">
            <thead>
                
            </thead>
        <tbody>
       		<tr>
                <td>作物名称</td>
                <td>
                	<input type="text" name="name" value="${statusCustom.name }">
                </td>
              </tr>
            <tr>
                <td>温度</td>
                <td><input type="text" name="temperature" value="${statusCustom.temperature }"></td>
            </tr>
            <tr>
                <td>湿度</td>
                <td><input type="text" name="moisture"  value="${statusCustom.moisture}"></td>
            </tr>
            <tr>
        
            </tr>
            <tr>
                <td>产量</td>
                <td><input type="text" name="production" value="${statusCustom.production }"></td>
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