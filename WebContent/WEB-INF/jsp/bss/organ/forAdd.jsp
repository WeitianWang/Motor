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
		<label for="firstname" class="col-sm-2 control-label">机构名称：</label>
		<div class="col-sm-10">
			<input id="name" name="name" class="form-control" placeholder="必填项"/>
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">机构别名：</label>
		<div class="col-sm-10">
			<input id="uri" name="uri" class="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">地址：</label>
		<div class="col-sm-10">
			<input id="icon" name="icon" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">电话：</label>
		<div class="col-sm-10">
			<input id="icon" name="icon" class="form-control" placeholder="必填项"/>
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">传真：</label>
		<div class="col-sm-10">
			<input id="order" name="order"  class="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">备注：</label>
		<div class="col-sm-10">
			<textarea class="form-control" rows="3" placeholder="组织机构说明"></textarea>
		</div>
	</div>
</form>