<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<form id="addForm" action="<%=basePath %>bss/organ/save.do" role="form" class="form-horizontal">
	<div class="form-group">
		<label for="parentCode" class="col-sm-2 control-label">上级：</label>
		<div class="col-sm-10">
			<p id="parentCode" class="form-control-static"></p>
		</div>
	</div>
	<div class="form-group">
		<label for="organName" class="col-sm-2 control-label">名称：</label>
		<div class="col-sm-10">
			<p id="organName" class="form-control-static"></p>
		</div>
	</div>
	<div class="form-group">
		<label for="abbr" class="col-sm-2 control-label">别名：</label>
		<div class="col-sm-10">
			<p id="abbr" class="form-control-static"></p>
		</div>
	</div>
	<div class="form-group">
		<label for="organType" class="col-sm-2 control-label">类型：</label>
		<div class="col-sm-10">
			<p id="organType" class="form-control-static"></p>
		</div>
	</div>
	<div class="form-group">
		<label for="addr" class="col-sm-2 control-label">地址：</label>
		<div class="col-sm-10">
			<p id="addr" class="form-control-static"></p>
		</div>
	</div>
	<div class="form-group">
		<label for="tel" class="col-sm-2 control-label">电话：</label>
		<div class="col-sm-10">
			<p id="tel" class="form-control-static"></p>
		</div>
	</div>
	<div class="form-group">
		<label for="fax" class="col-sm-2 control-label">传真：</label>
		<div class="col-sm-10">
			<p id="fax" class="form-control-static"></p>
		</div>
	</div>
	<div class="form-group">
		<label for="comments" class="col-sm-2 control-label">备注：</label>
		<div class="col-sm-10">
			<p id="comments" class="form-control-static"></p>
		</div>
	</div>
</form>