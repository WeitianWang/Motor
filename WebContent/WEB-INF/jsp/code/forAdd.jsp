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
				    <input type="text" class="form-control" id=packageName name="packageName" placeholder="例如：org.motor.bss">
				  </div>
		      	 <div class="form-group">
				    <label for="className">类名:</label>
				    <input type="text" class="form-control" id="className" name="className" placeholder="例如：User">
				  </div>
		      	 <div class="form-group">
				    <label for="jspPath">JSP路径:</label>
				    <input type="text" class="form-control" id="jspPath" name="jspPath" placeholder="例如：User">
				  </div>
		      </form>
		      <div class="table-responsive">
			      <table id="propTable" class="table table-hover">
			      	<thead>
			      		<tr>
			      			<th>属性名</th>
			      			<th>类型</th>
			      			<th>主键</th>
			      			<th>备注</th>
			      		</tr>
			      	</thead>
			      	<tbody id="propTbody">
			      	</tbody>
			      </table>
		      </div>
		      <div>
		      	<button id="addPropertyBtn" class="btn btn-primary">添加属性</button>
		      	<button id="generateBtn" class="btn btn-success">生成代码</button>
		      </div>
		   </div>
		</div>
	</div>
</div>
<div class="modal fade" id="addModal" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="background-color: #1BBC9B;color: white;">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="addModalLabel">添加属性</h4>
			</div>
			<div id="addContent" class="modal-body form-group">
	        	<form id="propertyForm" class="form-horizontal">
	        		<div id="form-group">
	        			<label class="col-sm-2 control-label" for="propertyName">属性名</label>
	        			<div class="col-sm-10">
	        				<input type="text" id="name" name="name" class="form-control" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')">
	        			</div>
	        		</div>
	        		<div id="form-group">
	        			<label class="col-sm-2 control-label" for="propertyName">类型</label>
	        			<div class="col-sm-1"></div>
	        			<div class="col-sm-3">
	        				<label class="radio">
								<input type="radio" name="type" value="String" checked="checked"> String
						   	</label>
	        			</div>
	        			<div class="col-sm-3">
	        				<label class="radio">
								<input type="radio" name="type" value="Integer" > Integer
						   	</label>
	        			</div>
	        			<div class="col-sm-3">
	        				<label class="radio">
								<input type="radio" name="type" value="Long" > Long
						   	</label>
	        			</div>
	        		</div>
	        		<div id="form-group">
	        			<label class="col-sm-3 control-label" for="propertyName"></label>
	        			<div class="col-sm-3">
	        				<label class="radio">
								<input type="radio" name="type" value="Byte" > Byte
						   	</label>
	        			</div>
	        			<div class="col-sm-3">
	        				<label class="radio">
								<input type="radio" name="type" value="Float" > Float
						   	</label>
	        			</div>
	        			<div class="col-sm-3">
	        				<label class="radio">
								<input type="radio" name="type" value="Date" > Date
						   	</label>
	        			</div>
	        		</div>
	        		<div id="form-group">
	        			<label class="col-sm-2 control-label" for="propertyName">备注</label>
	        			<div class="col-sm-10">
	        				<input type="text" name="comments" class="form-control">
	        			</div>
	        		</div>
	        		<div id="form-group">
	        			<label class="col-sm-3 control-label" for="propertyName"></label>
	        			<div class="col-sm-9">
	        			   <label class="checkbox">
								<input type="checkbox" name="isPrimaryKey" value="true"> 设置为主键
						   </label>
	        			</div>
	        		</div>
	        	</form>
	        </div>
	        <div class="modal-footer">
	            <button id="add" type="button" class="btn btn-primary">添加</button>
	            <button id="close" type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
	        </div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script type="text/javascript" src="<%=basePath %>assets/js/motor/code/code.js"></script>
</body>
</html>