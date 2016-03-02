$(function(){
	$('#generateBtn').click(function(){
		var form = $('#codeForm'),info=form.serializeArray(),trs = $('tr',$('#propTbody')),propArr = new Array(),obj = {};
		_url = Common.getBasePath()+'/code/generateCode.do';
		$.each(info,function(i,p){
			obj[p.name]=p.value;
		});
		 $.each(trs,function(i,tr){
			 var prop = $(this).data('prop');
			 var p = {
					 'name':prop['name'],
					 'type':prop['type'],
					 'isPrimaryKey':prop['isPrimaryKey']||false,
					 'comments':prop['comments']||''
			 }
			propArr.push(p);
		 });
		 //obj['properties'] = propArr;
		 var propDiv = $('#props');
		 $.each(propArr,function(i,p){
			 var nameInput=$('<input name="properties['+i+'].name" value="'+p.name+'"/>'),
			 		typeInput=$('<input name="properties['+i+'].type" value="'+p.type+'"/>'),
			 		isPKInput=$('<input name="properties['+i+'].isPrimaryKey" value="'+p.isPrimaryKey+'"/>'),
			 		commentInput=$('<input name="properties['+i+'].comments" value="'+p.comments+'"/>')
			 propDiv.append(nameInput).append(typeInput).append(isPKInput).append(commentInput);		
		 });
		 debugger;
		 $.ajax({
			 url:_url,
			 type:'post',
			 //data:JSON.stringify(obj),
			 //data:$.param(obj),
			 data:form.serialize(),
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
		var comments = obj['comments']||'';
		tr.html('<td>'+obj.name+'</td>'+'<td>'+obj.type+'</td>'+'<td>'+key+'</td>'+'<td>'+comments+'</td>');
		tr.data('prop',obj);
		tr.appendTo($('#propTbody'));
		form[0].reset();
	});
});