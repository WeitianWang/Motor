$(function(){
	init();
	$('#saveBtn').on('click',function(){
		var form = $('#addForm');
		form.action = Common.getBasePath() + '/bss/stuff/save.do';
		form.method = 'POST';
		var _data = form.serialize();
		$.ajax({
			url:Common.getBasePath() + '/bss/stuff/save.do',
			type:'POST',
			data:_data,
			dataType:'json',
			success:function(){
				$('#content').load(Common.getBasePath() + '/bss/stuff/forList.do');
			}
		});
	});
});

function init(){
	$("#hiredate").inputmask("yyyy-mm-dd");
	$("#termdate").inputmask("yyyy-mm-dd");
}