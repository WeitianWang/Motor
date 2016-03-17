$(function(){
	$('#table').bootstrapTable({
	    url:Common.getBasePath()+'/bss/stuff/list.do',
	    pagination:true,
	    method:'post',
	    sidePagination: 'server',
	    idField:'id',
	    pageList:[10,25,50,100],
	    striped: true,
	    pageSize:10,
	    pageNumber:1,
	    clickToSelect:true,
	    singleSelect:true,
	    minimumCountColumns: 2,
	    queryParams:function(params){
	    	return getQeuryParams(params);
	    },
	    search:true,
	    strictSearch:true,
	    showHeader:true,
	    toolbar:'#toolbar',
	    showColumns:true,
	    showRefresh:true,
	    contentType: "application/x-www-form-urlencoded",
		columns: [
			{
			    field: 'id',
//			    radio:true,
			    checkbox:true
			}, {
			    field: 'name',
			    title: '姓名',
			    halign:'center',
			    align:'center',
			    width:100
			}, {
			    field: 'organCode',
			    title: '部门',
			    halign:'center',
			    align:'center'
			}, {
			    field: 'job',
			    title: '岗位',
			    halign:'center',
			    align:'center'
			}, {
			    field: 'jobStatus',
			    title: '岗位状态',
			    halign:'center',
			    align:'center'
			}, {
			    field: 'phone',
			    title: '手机',
			    halign:'center',
			    align:'center'
			}, {
			    field: 'education',
			    title: '学历',
			    halign:'center',
			    align:'center'
			}, {
			    field: 'nation',
			    title: '民族',
			    halign:'center',
			    align:'center'
			}, {
			    field: 'politicalStatus',
			    title: '政治面貌',
			    halign:'center',
			    align:'center',
			    width:100
			}
	    ]
	});
});

function getQeuryParams(params){
	var opt = $('#table').bootstrapTable('getOptions');
	
	var p = {
			pageSize:params.limit,
			pageNumber:opt.pageNumber
	}
	return p;
}

function forDetail(){
	$('#content').load(Common.getBasePath() + '/bss/stuff/forDetail.do');
}

function forAdd(){
	$('#content').load(Common.getBasePath() + '/bss/stuff/forAdd.do');
}

function forUpdate(){
	
}

function forDelete(){
	
}