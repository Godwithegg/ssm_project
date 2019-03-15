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
    <style type="text/css">
    	body{
    		background-color:#f8f8f8;
    	}
    	#headTop{
    		height:30px;
    	}
    </style>
</head>
<body>
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">    <!--navbar-fixed-bottom决定了顶部底部，固定的-->
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
               <!-- <input name="statusCustom.name" class="form-control" placeholder="搜索"> -->
            </div>
        </form>
        <div id="headTop" class="pull-right col-md-1 text-center">
	          <a class="dropdown-toggle" data-toggle="dropdown">
	              <span class="glyphicon glyphicon-option-vertical"></span>
	         </a>
	        <ul class="dropdown-menu" role="menu">
	            <li class="dropdown-item"><a href="#">当前用户：${username } <span class="glyphicon glyphicon-user"></span></a></li>
	            <li class="dropdown-item">
	                <c:if test="${username != null}">
	                <a href="${pageContext.request.contextPath}/logout.action">退出登录<span class="glyphicon glyphicon-remove"></span></a>
	                </c:if>
	            </li>
        </ul>
        </div>
    </div>
	<div>
	    <form name="itemsForm" action="${pageContext.request.contextPath }/crop/queryStatus.action" method="post">
	        <div class="panel panel-default"><br/><hr/>
	            <div class="panel-heading">
	                商品查询<input name="statusCustom.name" />
	            <input type="button" class="btn-success" value="查询" onclick="queryItems()"/>
	            <input type="button" class="btn-info" value="数据展示" onclick="playItems()">
	            </div>
	            <table class="table">
	                <thead>
	                    <tr class="active">
	                    	<th>选择</th>
	                        <th>作物名称</th>
	                        <th>温度(°c)</th>
	                        <th>湿度(%)</th>
	                        <th>产量(kg)</th>
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
	                                <td><a href="${pageContext.request.contextPath }/crop/editStatus.action?id=${item.id}">修改</a><span class="glyphicon glyphicon-pencil"></span></td>
	                       			<td><input type="button" class="btn-danger" value="删除" onclick="deleteItems()"><span class="glyphicon glyphicon-trash"></span></td>
	                        
	                        </tr>
	                    </c:forEach>
	                </tbody>
	            </table>
	        </div>
	    </form>
	</div>
</body>
<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</html>