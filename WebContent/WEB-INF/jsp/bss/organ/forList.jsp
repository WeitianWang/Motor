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
<title>组织机构管理</title>
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
 .toolBtn{
 	top:-6px;
 }
</style>
</head>
<body>
<div class="row">
<div class="col-xs-12">
	<div class="panel panel-primary">
		<div class="panel-heading">
		<div class="btn-group" role="group" >
		  <div id="addBtnList" class="btn-group" role="group">
		    <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		      增加<span class="caret"></span>
		    </button>
		    <ul class="dropdown-menu">
		      <li><a href="#" class="add" organType="01">单位</a></li>
		      <li><a href="#" class="add" organType="02">部门</a></li>
		      <li><a href="#" class="add" organType="03">职位</a></li>
		    </ul>
		  </div>
		  <button id="detailBtn" type="button" class="btn btn-default"><span class="fa fa-eye"></span>查看</button>
		  <button id="updateBtn" type="button" class="btn btn-warning"><span class="fa fa-pencil-square-o"></span>修改</button>
		  <button id="delBtn" type="button" class="btn btn-danger"><span class="fa fa-trash"></span>删除</button>
		</div>
		</div>
		<div class="table-responsive">
			<table id="treetable" class="table table-hover table-striped table-bordered">
					<colgroup>
						<col width="*"></col>
						<col width="100px"></col>
						<col width="100px;"></col>
						<col width="200px"></col>
						<col width="220px"></col>
					</colgroup>
					<thead>
						<tr align="center">
							<th class="m_textCenter">名&nbsp;&nbsp;称</th>
							<th class="m_textCenter">类型</th>
							<th class="hidden-sm m_textCenter">电话</th>
							<th class="hidden-xs m_textCenter">传真</th>
							<th class="m_textCenter hidden-xs hidden-sm">地址</th>
						</tr>
					</thead>
					<tbody>
						<tr> <td></td> <td class="m_textCenter"></td> <td class="hidden-sm m_textCenter"></td> <td class="hidden-xs m_textCenter"></td> <td class="m_textCenter hidden-xs hidden-sm"></td> </tr>
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
					<h4 class="modal-title" id="addModalLabel">新增组织机构</h4>
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
		            <button id="save2Btn" type="button" class="btn btn-primary">修改</button>
		            <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
		        </div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
</div>
</div>
<script type="text/javascript" src="<%=basePath %>assets/js/motor/bss/organ/forList.js"></script>
</body>
</html>