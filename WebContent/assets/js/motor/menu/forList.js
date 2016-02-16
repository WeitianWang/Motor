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
		source: {url: "../bss/menu/getList.do", debugDelay: 1000},
		renderColumns: function(event, data) {
			var node = data.node,$tdList = $(node.tr).find(">td");
			$tdList.eq(1).text(node.data.uri);
			$tdList.eq(2).text(node.icon);
			$tdList.eq(3).text(node.data.target=='_blank'?'新窗口':'默认');
			$tdList.eq(4).text(node.data.order);
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
	}
	
	//新增
	$('#addBtn').on('click',function(){
		var table = $("#treetable").fancytree('getTree'),
			node = table.getActiveNode(),
			url='../bss/menu/forAdd.do';
		//debugger;
		if(node!=null){
			url += '?pid='+node.key+'&parentName='+node.title;
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
					}
				});
			});
			//情况对话框内容
			$('#addModal').on('hidden.bs.modal', function () {
				$('#addForm').html(null);
			});
		});
	});
	
	//查看详细
	$('#detailBtn').on('click',function(){
		var node = getActiveNode();
		if(!node) return;
		$('#detailContent').load('../bss/menu/forDetail.do',function(){
			var	data = node.data,key,value;
			for(key in data){
				if(key=='target'){
					value = data.target;
					$('#target').text(value=='_blank'?'新窗口':'默认');
					continue;
				}
				$('#'+key).text(data[key]);
			}
			$('#icon').text(node.icon);
			$('#iconStyle').addClass(node.icon);
			$('#detailModal').modal('show');
			$('#detailModal').on('hide.bs.modal', function () {
				$('#detailForm').html(null);
			});
		});
	});
	//修改
	$('#updateBtn').on('click',function(){
		var node = getActiveNode();
		if(!node) return;
		$('#detailContent').load('../bss/menu/forDetail.do?id='+node.id,function(){
//			var	data = node.data,key,value;
//			for(key in data){
//				if(key=='target'){
//					value = data.target;
//					$('#target').text(value=='_blank'?'新窗口':'默认');
//					continue;
//				}
//				$('#'+key).text(data[key]);
//			}
//			$('#icon').text(node.icon);
//			$('#iconStyle').addClass(node.icon);
//			$('#detailModal').modal('show');
//			$('#detailModal').on('hide.bs.modal', function () {
//				$('#detailForm').html(null);
//			});
		});
	});
	//删除
	$('#delBtn').on('click',function(){
		var node = getActiveNode();
		if(!node) return;
		if(node.children){
			sweetAlert("Oops...", "当前选中菜单项含有子菜单，不能删除!", "error");
			return;
		}else{
			swal(
				{
					title : "确定要删除吗?",
					text : "删除后将无法恢复!",
					type : "warning",
					showCancelButton : true,
					confirmButtonColor : "#DD6B55",
					confirmButtonText : "Yes, delete it!",
					closeOnConfirm : false
				},
				function() {
					$.ajax({
						url:'../bss/menu/delete.do',
						type:'post',
						data:{id:node.key},
						dataType:'json',
						success:function(r){
							if(r.success){
								node.remove();
								swal("删除成功!", '记录已经被删除', "success")
							}else{
								sweetAlert("Oops...", r.error, "error");
							}
						}
					});
				}
			);
		}
	});
});
