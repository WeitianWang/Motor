$(function(){
	$.ajax({
		type:'post',
		url:Common.getBasePath()+'/bss/menu/getMenuTree.do',
		success:function(d){
			var opt = {
					data:d,
					onClick:function(menu){
						if(menu['uri']){
							$('#content').load(Common.getBasePath()+'/'+menu['uri'],{d:new Date()});
						}
					}
			};
			$('#menu').MotorMenu(opt);
		}
	});
	$('#searchForm').MotorSearchForm();
	$('#user-panel').UserPanel();
	
	var screenSizes = {
		    xs: 480,
		    sm: 768,
		    md: 992,
		    lg: 1200
		};
	$('[data-toggle="offcanvas"]').on('click',function(e){
		e.preventDefault();
		//Enable sidebar push menu
		if ($(window).width() > (screenSizes.sm - 1)) {
			if ($("body").hasClass('sidebar-collapse')) {
				$("body").removeClass('sidebar-collapse');
			} else {
				$("body").addClass('sidebar-collapse');
			}
		}else {//Handle sidebar push menu for small screens
			if ($("body").hasClass('sidebar-open')) {
				$("body").removeClass('sidebar-open').removeClass('sidebar-collapse');
			} else {
				$("body").addClass('sidebar-open');
			}
		}
	});
});