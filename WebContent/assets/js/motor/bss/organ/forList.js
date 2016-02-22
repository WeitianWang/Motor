$(function(){
	glyph_opts = {
			map: {
				doc: "glyphicon glyphicon-file",
				docOpen: "glyphicon glyphicon-file",
				checkbox: "fa fa-square-o",
				checkboxSelected: "fa fa-check-square-o",
				checkboxUnknown: "glyphicon glyphicon-share",
				dragHelper: "glyphicon glyphicon-play",
				dropMarker: "glyphicon glyphicon-arrow-right",
				error: "glyphicon glyphicon-warning-sign",
				expanderClosed: "fa fa-plus-square",
				expanderLazy: "glyphicon glyphicon-plus-sign",
				expanderOpen: "fa fa-minus-square",
				folder: "glyphicon glyphicon-folder-close",
				folderOpen: "glyphicon glyphicon-folder-open",
				loading: "glyphicon glyphicon-refresh glyphicon-spin"
			}
	};
	
	$("#treetable").fancytree({
		extensions: ["glyph", "table"],
		selectMode:1,
		autoCollapse:true,
		glyph: glyph_opts,
		source: {url: "../bss/organ/getList.do", debugDelay: 1000},
		renderColumns: function(event, data) {
			var node = data.node,
				  $tdList = $(node.tr).find(">td"),
				  organType = node.data.organType;
			$tdList.eq(1).text(organType=='01'?'单位':(organType=='02'?'部门':'职工'));
			$tdList.eq(2).text(node.data.tel);
			$tdList.eq(3).text(node.data.fax);
			$tdList.eq(4).text(node.data.addr);
		}
	});
	
	//获取选中行
	var getActiveNode = function(){
		var table = $("#treetable").fancytree('getTree'),
		node = table.getActiveNode();
		if(node==null){
			sweetAlert("Oops...", "请选择一行记录!", "warning");
			return false;
		}
		return node;
	};
	
	//新增
	$('#addBtnList .add').on('click',function(){
		var table = $("#treetable").fancytree('getTree'),
			  node = table.getActiveNode(),
			  url=Common.getBasePath()+'/bss/organ/forAdd.do',
			  organType=$(this).attr('organType');
		if(node==null&&organType!="01"){
			//url += '?pid='+node.key+'&parentName='+node.title;
			sweetAlert("Oops...", "顶级节点不允许创建"+$(this).text()+"，请先创建单位!", "warning");
			return;
		}
		
		$('#addContent').load(url,function(){
			$('#addModal').modal('show');
			//保存
			$('#saveBtn').click(function(){
				var _data = $('#addForm').serialize();
				var form = $('#addForm');
				$.ajax({
					url:form[0].action,
					type:'post',
					data:form.serialize(),
					dataType:'json',
					success:function(r){
						if(r.success){
							if(node==null){
								table.getFirstChild().addNode(r.menu,'before');
							}else{
								node.addChildren([r.menu]);
							}
							$('#addModal').modal('hide');
							swal("保存成功!", '新增菜单已保存', "success");
						}else{
							sweetAlert("Oops...", r.error, "error");
						}
						//情况对话框内容
						$('#addForm').html(null);
					}
				});
			});
		});
	});
});