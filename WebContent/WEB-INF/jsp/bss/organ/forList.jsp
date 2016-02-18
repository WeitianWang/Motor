<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<title>组织机构</title>
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
<script type="text/javascript" src="<%=basePath %>assets/js/motor/bss/organ/forList.js"></script>
</body>
</html>