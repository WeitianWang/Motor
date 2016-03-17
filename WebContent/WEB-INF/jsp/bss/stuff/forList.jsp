<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<style type="text/css">
	button{
		height: 34px;
	}
</style>
<title>员工管理</title>
</head>
<body>
<div id="toolbar">
    <div class="form-inline" role="form">
        <div class="btn-group" role="group">
	       	<button id="addBtn" type="button" class="btn btn-success" onclick="forAdd()"><span class="fa fa-plus-circle"></span>增加</button>
		    <button id="detailBtn" type="button" class="btn btn-default" onclick="forDetail()"><span class="fa fa-eye"></span>查看</button>
		  	<button id="updateBtn" type="button" class="btn btn-warning" onclick="forUpdate()"><span class="fa fa-pencil-square-o"></span>修改</button>
		  	<button id="delBtn" type="button" class="btn btn-danger" onblur="forDelete()"><span class="fa fa-trash"></span>删除</button>
        </div>
    </div>
</div>
<table id="table"></table>

<script type="text/javascript" src="<%=basePath %>assets/js/motor/bss/stuff/forList.js"></script>
</body>
</html>