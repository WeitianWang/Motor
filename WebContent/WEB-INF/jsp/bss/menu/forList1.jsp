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
<title>新增菜单</title>
<link rel="stylesheet" href="<%=basePath %>assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath %>assets/lib/font/awesome/css/font-awesome.min.css">
<script type="text/javascript" src="<%=basePath %>assets/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>assets/bootstrap/js/bootstrap.js"></script>
<link href="<%=basePath %>assets/lib/fancytree/skin-bootstrap/ui.fancytree.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath %>assets/lib/jqueryUI/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>assets/lib/fancytree/jquery.fancytree-all.min.js"></script>
<script type="text/javascript" src="<%=basePath %>assets/lib/fancytree/jquery.fancytree.glyph.js"></script>

<script type="text/javascript">
glyph_opts = {
		map: {
			doc: "glyphicon glyphicon-file",
			docOpen: "glyphicon glyphicon-file",
			checkbox: "glyphicon glyphicon-unchecked",
			checkboxSelected: "glyphicon glyphicon-check",
			checkboxUnknown: "glyphicon glyphicon-share",
			dragHelper: "glyphicon glyphicon-play",
			dropMarker: "glyphicon glyphicon-arrow-right",
			error: "glyphicon glyphicon-warning-sign",
			expanderClosed: "glyphicon glyphicon-plus-sign",
			expanderLazy: "glyphicon glyphicon-plus-sign",  // glyphicon-expand
			expanderOpen: "glyphicon glyphicon-minus-sign",  // glyphicon-collapse-down
			folder: "glyphicon glyphicon-folder-close",
			folderOpen: "glyphicon glyphicon-folder-open",
			loading: "glyphicon glyphicon-refresh glyphicon-spin"
		}
	};
$(function(){
	// Initialize Fancytree
	$("#tree").fancytree({
		extensions: ["dnd", "edit", "glyph", "wide"],
		checkbox: true,
		dnd: {
			focusOnClick: true,
			dragStart: function(node, data) { return true; },
			dragEnter: function(node, data) { return false; },
			dragDrop: function(node, data) { data.otherNode.copyTo(node, data.hitMode); }
		},
		glyph: glyph_opts,
		selectMode: 2,
		source: {url: "<%=basePath %>assets/lib/fancytree/ajax-tree-taxonomy.json", debugDelay: 1000},
		toggleEffect: { effect: "drop", options: {direction: "left"}, duration: 400 },
		wide: {
			iconWidth: "1em",     // Adjust this if @fancy-icon-width != "16px"
			iconSpacing: "0.5em", // Adjust this if @fancy-icon-spacing != "3px"
			levelOfs: "1.5em"     // Adjust this if ul padding != "16px"
		},

		icon: function(event, data){
			// if( data.node.isFolder() ) {
			// 	return "glyphicon glyphicon-book";
			// }
		},
		lazyLoad: function(event, data) {
			data.result = {url: "<%=basePath %>assets/lib/fancytree/ajax-sub2.json", debugDelay: 1000};
		}
	});

	$("#treetable").fancytree({
		extensions: ["dnd", "edit", "glyph", "table"],
		checkbox: true,
		dnd: {
			focusOnClick: true,
			dragStart: function(node, data) { return true; },
			dragEnter: function(node, data) { return true; },
			dragDrop: function(node, data) { data.otherNode.copyTo(node, data.hitMode); }
		},
		glyph: glyph_opts,
		source: {url: "<%=basePath %>assets/lib/fancytree/ajax-tree-taxonomy.json", debugDelay: 1000},
		table: {
			checkboxColumnIdx: 1,
			nodeColumnIdx: 2
		},

		activate: function(event, data) {
		},
		lazyLoad: function(event, data) {
			data.result = {url: "<%=basePath %>assets/lib/fancytree/ajax-sub2.json", debugDelay: 1000};
		},
		renderColumns: function(event, data) {
			debugger;
			var node = data.node,
				$tdList = $(node.tr).find(">td");
			$tdList.eq(0).text(node.getIndexHier());
			$tdList.eq(3).text(!!node.folder);
		}
	});
	
	$("#btnExpandAll").click(function(){
		$("#tree").fancytree("getTree").visit(function(node){
			node.setExpanded(true);
		});
	});
	$("#btnCollapseAll").click(function(){
		$("#tree").fancytree("getTree").visit(function(node){
			node.setExpanded(false);
		});
	});

	$( "#fontSize" ).change(function(){
		$("#tree .fancytree-container").css("font-size", $(this).prop("value") + "pt");
	});//.prop("value", 12);

	$("#plainTreeStyles").on("change", "input", function(e){
		$("#tree ul").toggleClass($(this).data("class"), $(this).is(":checked"));
	});
	$("#bootstrapTableStyles").on("change", "input", function(e){
		$("#treetable").toggleClass($(this).data("class"), $(this).is(":checked"));
	});
});
</script>
<style type="text/css">
		body {
			padding: 15px;
		}
		ul.fancytree-container {
			border: none;
		}
		/* Reduce bootstrap's default 'panel' padding: */
		div#tree {
			padding: 3px 5px;
		}
		#treetable {
		table-layout: fixed;
	}
	#treetable tr td:nth-of-type(1) {
		text-align: right;
	}
	#treetable tr td:nth-of-type(2) {
		text-align: center;
	}
	#treetable tr td:nth-of-type(3) {
		min-width: 100px;
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
	}
	</style>
</head>
<body>
<div class="row">
<div class="col-xs-12" style="">
	<p>
		Font size: <span id="curSize"></span>
		<input id="fontSize" type="number" min="4" max="48" value="10"> pt
	</p>

	<h3> Plain tree </h3>

	<p id="plainTreeStyles">
		<b>Add container class:</b><br>
<!--
		<label><input type="checkbox" data-class="fancytree-colorize-hover"> fancytree-colorize-hover</label>
-->
		<label><input type="checkbox" data-class="fancytree-colorize-selected"> fancytree-colorize-selected</label>
	</p>

	<div class="panel panel-default">
		<div class="panel-heading">
			<b>Taxonomy</b>
		</div>
		<div id="tree" class="panel-body fancytree-colorize-hover">
		</div>
		<div class="panel-footer">
			<button id="btnExpandAll" class="btn btn-xs btn-primary">Expand all</button>
			<button id="btnCollapseAll" class="btn btn-xs btn-warning">Collapse all</button>
		</div>
	</div>

	<h3> Table tree </h3>

	<p id="bootstrapTableStyles">
		<b>Add table class:</b><br>
		<label><input type="checkbox" data-class="table-bordered"> table-bordered</label>
		<label><input type="checkbox" data-class="table-condensed" checked="checked"> table-condensed</label>
		<label><input type="checkbox" data-class="table-striped" checked="checked"> table-striped</label>
		<label><input type="checkbox" data-class="table-hover" checked="checked"> table-hover</label>
		<label><input type="checkbox" data-class="table-responsive"> table-responsive</label>
		<label><input type="checkbox" data-class="fancytree-colorize-selected"> fancytree-colorize-selected</label>
	</p>

	<table id="treetable" class="table table-condensed table-hover table-striped">
		<colgroup>
			<col width="80px"></col>
			<col width="30px"></col>
			<col width="*"></col>
			<col width="100px"></col>
			<col width="100px"></col>
			<col width="100px"></col>
		</colgroup>
		<thead>
			<tr> <th></th> <th></th> <th>Classification</th> <th>Folder</th> <th></th> <th></th> </tr>
		</thead>
		<tbody>
			<tr> <td></td> <td></td> <td></td> <td></td> <td></td> <td></td> </tr>
		</tbody>
	</table>


	<!-- Start_Exclude: This block is not part of the sample code -->
	<hr>
	<p class="sample-links  no_code">
		<a class="hideInsideFS" href="https://github.com/mar10/fancytree/">Fancytree project home</a>
		<a class="hideOutsideFS" href="#">Link to this page</a>
		<a class="hideInsideFS" href="index.html">Example Browser</a>
		<a href="#" id="codeExample">View source code</a>
	</p>
</div>
</div>
</body>
</html>