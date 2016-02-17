<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<form id="updateForm" action="<%=basePath %>bss/menu/update.do" role="form" class="form-horizontal">
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">上级：</label>
		<div class="col-sm-10">
			<p class="form-control-static">${parentName }</p>
			<input id="pid" name="pid" value="${menu.pid }" hidden="true"/>
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">名称：</label>
		<div class="col-sm-10">
			<input id="id" name="id" value="${menu.id }" hidden="true"/>
			<input id="name" name="name" class="form-control" value="${menu.name }"/>
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">URI：</label>
		<div class="col-sm-10">
			<input id="uri" name="uri" class="form-control" value="${menu.uri }"/>
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">图标：</label>
		<div class="col-sm-10">
			<input id="icon" name="icon" class="form-control" value="${menu.icon }"/>
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">Target：</label>
		<div class="col-sm-10">
			<select id="target" name="target" class="form-control">
				<option value="_self">默认</option>
				<option value="_blank" ${menu.target=='_blank'?'selected':'' }>新窗口</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">排序：</label>
		<div class="col-sm-10">
			<input id="order" name="order" type="number" class="form-control" value="${menu.order }"/>
		</div>
	</div>
</form>