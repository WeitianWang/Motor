$(function(){
	$('#generateBtn').click(function(){
		var form = $('#codeForm'),info=form.serializeArray(),trs = $('tr',$('#propTbody')),propArr = new Array(),obj = {};
		_url = Common.getBasePath()+'/code/generateEntity.do';
		$.each(info,function(i,p){
			obj[p.name]=p.value;
		});
		 $.each(trs,function(i,tr){
			propArr.push($(this).data('prop'));
		 });
		 obj['properties'] = propArr;
		 debugger;
		 $.ajax({
			 url:_url,
			 type:'post',
			 //data:JSON.stringify(obj),
			 data:$.param(obj),
			 dataType:'json',
			 success:function(r){
				 
			 }
		 });
		//form.submit();
	});
	
	$('#addPropertyBtn').click(function(){
		$('#addModal').modal('show');
	});
	
	$('#add').click(function(){
		var form = $('#propertyForm'),
			  prop = form.serializeArray(),
			  obj = {},
			  tr = $('<tr></tr>');
		$.each(prop,function(i,p){
			obj[p.name]=p.value;
		});
		var key = obj.isPrimaryKey=='true'?true:'';
		tr.html('<td>'+obj.name+'</td>'+'<td>'+obj.type+'</td>'+'<td>'+key+'</td>'+'<td>'+'rrrrrrrrr'+'</td>');
		tr.data('prop',obj);
		tr.appendTo($('#propTbody'));
		form[0].reset();
	});
});