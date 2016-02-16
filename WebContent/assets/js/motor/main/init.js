$(function(){
		var items=[
			{
				id:'1',
			name:'菜单管理',
			clazz:'fa-laptop',
			children:[
			    {
			    	id:'1.1',
					name:'新增',
					url:'bss/menu/forList.do'
					
			    },{
			    	id:'1.2',
					name:'Menu1.2',
					
			    },{
			    	id:'1.3',
					name:'Menu1.3',
					children:[
					    {
					    	id:'1.3.1',
						    name:'1.3.1'
					    }
					]
			    }
			]
		},{
			id:'2',
			name:'Menu2',
			clazz:'fa-book',
			children:[
			    {
			    	id:'2.1',
					name:'Menu2.1'
					
			    },{
			    	id:'2.2',
					name:'Menu2.2'
					
			    },{
			    	id:'2.3',
					name:'Menu2.3'
					
			    }
			]
		},{
			id:'3',
			name:'Menu3',
			clazz:'fa-cogs',
			children:[]
		}
	];
//	var opt = {
//			data:items,
//			onClick:function(menu){
//				if(menu['url']){
//					$('#content').load('http://localhost:8080/Motor/'+menu['url'],{d:new Date()});
//					//$('#runtime').attr('src','http://localhost:8080/Motor/'+menu['url']);
//				}
//			}
//	};
	$.ajax({
		type:'post',
		url:Common.getBasePath()+'/bss/menu/getMenuTree.do',
		success:function(d){
			var opt = {
					data:d,
					onClick:function(menu){
						//alert(menu['url'])
						$('#content').load('http://localhost:8080/Motor/bss/menu/forList.do');
						if(menu['url']){
							//$('#content').load(Common.getBasePath()+'/'+menu['url'],{d:new Date()});
						}
					}
			};
			$('#menu').MotorMenu(opt);
		}
	});
	$('#searchForm').MotorSearchForm();
	$('#user-panel').UserPanel();
	//$('#header').Header();
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