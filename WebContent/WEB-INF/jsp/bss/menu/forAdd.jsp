<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<form id="addForm" action="<%=basePath %>bss/menu/save.do" role="form" class="form-horizontal">
	<div class="form-group">
		<label for="parentName" class="col-sm-2 control-label">上级：</label>
		<div class="col-sm-10">
			<p id="parentName" class="form-control-static">${parentName }</p>
			<input id="pid" name="pid" value="${pid }" hidden="true"/>
		</div>
	</div>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">名称：</label>
		<div class="col-sm-10">
			<input id="name" name="name" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label for="uri" class="col-sm-2 control-label">URI：</label>
		<div class="col-sm-10">
			<input id="uri" name="uri" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label for="icon" class="col-sm-2 control-label">图标：</label>
		<div class="col-sm-10">
			<input id="icon" name="icon" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label for="target" class="col-sm-2 control-label">Target：</label>
		<div class="col-sm-10">
			<select id="target" name="target" class="form-control">
				<option value="_self">默认</option>
				<option value="_blank">新窗口</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="order" class="col-sm-2 control-label">排序：</label>
		<div class="col-sm-10">
			<input id="order" name="order" type="number" class="form-control" value="1"/>
		</div>
	</div>
</form>