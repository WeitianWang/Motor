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
<title>新增员工</title>
<style type="text/css">
	.show-grid {
	    margin-bottom: 15px;
	}
</style>
</head>
<body>
<form>
	<div class="panel panel-default">
		<div class="panel-heading">职位信息</div>
		<div class="panel-body">
			<div class="row show-grid">
				<label for="id"  class="col-md-1 form-control-static">员工编号：</label>
				<div class="col-md-3">
				    <input type="text" class="form-control" id="id" name="id">
				</div>
				<label for="name"  class="col-md-1 form-control-static">员工姓名：</label>
				<div class="col-md-3">
				    <input type="text" class="form-control" id="name" name="name">
				</div>
				<label for="organCode"  class="col-md-1 form-control-static">部门：</label>
				<div class="col-md-3">
				    <input type="text" class="form-control" id="organCode" name="organCode">
				</div>
			</div>
			
			<div class="row show-grid">
				<label for="job"  class="col-md-1 form-control-static">岗位：</label>
				<div class="col-md-3">
				    <input type="text" class="form-control" id="job" name="job">
				</div>
				<label for="hiredate"  class="col-md-1 form-control-static">入职日期：</label>
				<div class="col-md-3">
				    <input type="date" class="form-control" id="hiredate" name="hiredate">
				</div>
				<label for="jobStatus"  class="col-md-1 form-control-static">岗位状态：</label>
				<div class="col-md-3">
				    <input type="text" class="form-control" id="jobStatus" name="jobStatus">
				</div>
			</div>
			<div class="row show-grid">
				<label for="termdate"  class="col-md-1 form-control-static">离职日期：</label>
				<div class="col-md-3">
				    <input type="date" class="form-control" id="termdate" name="termdate">
				</div>
			</div>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">联系方式</div>
		<div class="panel-body">
			<div class="row show-grid">
				<label for="phone"  class="col-md-1 form-control-static">手机：</label>
				<div class="col-md-3">
				    <input type="text" class="form-control" id="phone" name="phone">
				</div>
				<label for="tel"  class="col-md-1 form-control-static">固话：</label>
				<div class="col-md-3">
				    <input type="text" class="form-control" id="tel" name="tel">
				</div>
				<label for="qq"  class="col-md-1 form-control-static">QQ：</label>
				<div class="col-md-3">
				    <input type="text" class="form-control" id="qq" name="qq">
				</div>
			</div>
			<div class="row show-grid">
				<label for="wechart"  class="col-md-1 form-control-static">微信：</label>
				<div class="col-md-3">
				    <input type="text" class="form-control" id="wechart" name="wechart">
				</div>
				<label for="addr"  class="col-md-1 form-control-static">住址：</label>
				<div class="col-md-7">
				    <input type="text" class="form-control" id="addr" name="addr">
				</div>
			</div>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">个人信息</div>
		<div class="panel-body">
			<div class="row show-grid">
				<label for="idCard"  class="col-md-1 form-control-static">身份证号：</label>
				<div class="col-md-3">
				    <input type="text" class="form-control" id="idCard" name="idCard">
				</div>
				<label for="gender"  class="col-md-1 form-control-static">性别：</label>
				<div class="col-md-3">
				    <select class="form-control" id="gender" name="gender">
				    	<option value="1">男</option>
				    	<option value="0">女</option>
				    </select>
				</div>
				<label for="birthday"  class="col-md-1 form-control-static">出生日期：</label>
				<div class="col-md-3">
				    <input type="date" class="form-control" id="birthday" name="birthday">
				</div>
			</div>
			<div class="row show-grid">
				<label for="nation"  class="col-md-1 form-control-static">民族：</label>
				<div class="col-md-3">
				    <input type="text" class="form-control" id="nation" name="nation">
				</div>
				<label for="nativeplace"  class="col-md-1 form-control-static">籍贯：</label>
				<div class="col-md-3">
				    <input type="text" class="form-control" id="nativeplace" name="nativeplace">
				</div>
				<label for="maritalStatus"  class="col-md-1 form-control-static">婚姻状况：</label>
				<div class="col-md-3">
				    <select class="form-control" id="maritalStatus" name="maritalStatus">
				    	<option value="1">未婚</option>
				    	<option value="2">已婚</option>
				    	<option value="3">离异</option>
				    	<option value="4">丧偶</option>
				    </select>
				</div>
			</div>
			<div class="row show-grid">
				<label for="politicalStatus"  class="col-md-1 form-control-static">政治面貌：</label>
				<div class="col-md-3">
				    <select class="form-control" id="politicalStatus" name="politicalStatus">
				    	<option>群众</option>
				    	<option>党员</option>
				    </select>
				</div>
				<label for="education"  class="col-md-1 form-control-static">学历：</label>
				<div class="col-md-3">
				    <input type="text" class="form-control" id="education" name="education">
				</div>
				<label for="major"  class="col-md-1 form-control-static">专业：</label>
				<div class="col-md-3">
				    <input type="text" class="form-control" id="major" name="major">
				</div>
			</div>
			<div class="row show-grid">
				<label for="domicilePlace"  class="col-md-1 form-control-static">户口所在地：</label>
				<div class="col-md-3">
				    <input type="text" class="form-control" id="domicilePlace" name="domicilePlace">
				</div>
			</div>
		</div>
	</div>
	<div class="row"">
		<div class="col-md-5"></div>
		<div class="col-md-1"><span class="btn btn-primary">保存<span style="text-align: right;" class="fa fa-save"></span></span></div>
		<div class="col-md-1"><span class="btn btn-danger">重置<span style="text-align: right;" class="fa fa-refresh"></span></span></div>
		<div class="col-md-5"></div>
	</div>
</form>
<script type="text/javascript" src="<%=basePath %>assets/js/motor/bss/stuff/forAdd.js"></script>
</body>
</html>