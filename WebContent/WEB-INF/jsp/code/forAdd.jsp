<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println(basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<title>代码生成</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="panel panel-default">
		   <div class="panel-body">
		      <form id="codeForm" action="<%=basePath %>code/generateEntity.do" >
		      	 <div class="form-group">
				    <label for="package">Java类包路径:</label>
				    <input type="text" class="form-control" id="package" placeholder="例如：org.motor.bss">
				  </div>
		      	 <div class="form-group">
				    <label for="className">类名:</label>
				    <input type="text" class="form-control" id="className" placeholder="例如：User">
				  </div>
		      	 <div class="form-group">
				    <label for="jspPath">JSP路径:</label>
				    <input type="text" class="form-control" id="jspPath" placeholder="例如：User">
				  </div>
		      </form>
		      <div class="table-responsive">
			      <table class="table table-hover">
			      	<thead>
			      		<tr>
			      			<th>属性名</th>
			      			<th>类型</th>
			      			<th>主键</th>
			      			<th>备注</th>
			      		</tr>
			      	</thead>
			      	<tbody>
			      	</tbody>
			      </table>
		      </div>
		      <div>
		      	<button class="btn btn-primary">添加属性</button>
		      	<button id="generateBtn" class="btn btn-success">生成代码</button>
		      </div>
		   </div>
		</div>
	</div>
</div>
<script type="text/javascript" src="<%=basePath %>assets/js/motor/code/code.js"></script>
</body>
</html>