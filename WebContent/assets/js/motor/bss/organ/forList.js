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
				  $tdList = $(node.tr).find(">td");
			$tdList.eq(1).text(node.data.uri);
			$tdList.eq(2).text(node.icon);
			$tdList.eq(3).text(node.data.target=='_blank'?'新窗口':'默认');
			$tdList.eq(4).text(node.data.order);
		}
	});
});