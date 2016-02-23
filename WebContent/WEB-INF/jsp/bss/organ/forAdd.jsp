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
		<label for="parentName" class="col-sm-2 control-label">上级：</label>
		<div class="col-sm-10">
			<input id="parentName" name="parentName" class="form-control" value="${parentName!=null?parentName:'无上级' }" disabled="disabled"/>
			<input id="parentCode" name="parentCode" hidden="true" value="${parentCode }" />
		</div>
	</div>
	<div class="form-group">
		<label for="organName" class="col-sm-2 control-label">名称：</label>
		<div class="col-sm-10">
			<input id="organName" name="organName" class="form-control" placeholder="必填项" required="required"/>
		</div>
	</div>
	<div class="form-group">
		<label for="abbr" class="col-sm-2 control-label">别名：</label>
		<div class="col-sm-10">
			<input id="abbr" name="abbr" class="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="organType1" class="col-sm-2 control-label">类型：</label>
		<div class="col-sm-10">
			<input id="organType1" name="organType1" value="${organType=='02'?'部门':(organType=='03'?'职位':'单位') }" class="form-control"  disabled="disabled"/>
			<input id="organType" name="organType" value="${organType }" hidden="true"/>
		</div>
	</div>
	<div class="form-group">
		<label for="addr" class="col-sm-2 control-label">地址：</label>
		<div class="col-sm-10">
			<input id="addr" name="addr" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label for="tel" class="col-sm-2 control-label">电话：</label>
		<div class="col-sm-10">
			<input id="tel" name="tel" class="form-control" placeholder="必填项" required="required"/>
		</div>
	</div>
	<div class="form-group">
		<label for="fax" class="col-sm-2 control-label">传真：</label>
		<div class="col-sm-10">
			<input id="fax" name="fax"  class="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="comments" class="col-sm-2 control-label">备注：</label>
		<div class="col-sm-10">
			<textarea id="comments" name="comments" class="form-control" rows="3" placeholder="组织机构说明"></textarea>
		</div>
	</div>
</form>