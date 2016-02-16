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
<title>新增菜单2</title>
<link href="<%=basePath %>assets/lib/fancytree/skin-bootstrap/ui.fancytree.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath %>assets/lib/jqueryUI/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>assets/lib/fancytree/jquery.fancytree-all.min.js"></script>
<script type="text/javascript" src="<%=basePath %>assets/lib/fancytree/jquery.fancytree.glyph.js"></script>
<style type="text/css">
 .m_textCenter{
 	text-align: center;
 }
 .panel-header-btn{
 	cursor: pointer;
 	margin-right: 10px;
 }
 
</style>
</head>
<body>
<div class="row">
<div class="col-xs-12" style="">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<b>
				<i class="fa fa-cogs"></i> &nbsp;菜单数据列表
			</b>
			<span class="pull-right" style="font-size: 16px;">
				<span id="addBtn" class="panel-header-btn"><i class="fa fa-plus"></i>&nbsp;增加</span>
				<span id="updateBtn" class="panel-header-btn"><i class="fa fa-pencil-square-o"></i>&nbsp;修改</span>
				<span id="delBtn" class="panel-header-btn"><i class="fa fa-trash"></i>&nbsp;删除</span>
				<span id="detailBtn" class="panel-header-btn"><i class="fa fa-eye"></i>&nbsp;查看</span>
			</span>
		</div>
		<div class="table-responsive">
			<table id="treetable" class="table table-hover table-striped table-bordered">
				<colgroup>
					<col width="*"></col>
					<col width="*"></col>
					<col width="200px;"></col>
					<col width="120px"></col>
					<col width="120px"></col>
				</colgroup>
				<thead>
					<tr align="center">
						<th class="m_textCenter">名&nbsp;&nbsp;称</th>
						<th>URI</th>
						<th class="hidden-sm m_textCenter">图标</th>
						<th class="hidden-xs m_textCenter">Target</th>
						<th class="m_textCenter hidden-xs hidden-sm">排序</th>
					</tr>
				</thead>
				<tbody>
					<tr> <td></td> <td></td> <td class="hidden-sm"></td> <td class="hidden-xs m_textCenter"></td> <td class="m_textCenter hidden-xs hidden-sm"></td> </tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<!-- 详细内容模态框（Modal） -->
	<div class="modal fade" id="detailModal" role="dialog" aria-labelledby="detailModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="background-color: #1BBC9B;color: white;">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="detailModalLabel">菜单详细</h4>
				</div>
				<div id="detailContent" class="modal-body form-group">
		        	<!-- /详细内容页面 -->
		        </div>
		        <div class="modal-footer">
		            <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
		        </div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<!-- 新增模态框（Modal） -->
	<div class="modal fade" id="addModal" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="background-color: #1BBC9B;color: white;">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="addModalLabel">新增菜单</h4>
				</div>
				<div id="addContent" class="modal-body form-group">
		        	<!-- /新增页面 -->
		        </div>
		        <div class="modal-footer">
		            <button id="saveBtn" type="button" class="btn btn-primary">保存</button>
		            <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
		        </div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<!-- 修改模态框（Modal） -->
	<div class="modal fade" id="updateModal" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="background-color: #1BBC9B;color: white;">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="addModalLabel">修改菜单</h4>
				</div>
				<div id="updateContent" class="modal-body form-group">
		        	<!-- /修改页面 -->
		        </div>
		        <div class="modal-footer">
		            <button id="saveBtn" type="button" class="btn btn-primary">保存</button>
		            <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
		        </div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
</div>
</div>
<script type="text/javascript" src="<%=basePath %>assets/js/motor/menu/forList.js"></script>
</body>
</html>