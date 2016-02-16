;(function (factory) {
	 "use strict";
	 
    if (typeof define === "function" && define.amd) {
        // AMD模式
        define([ "jquery" ], factory);
    } else {
        // 全局模式
        factory(jQuery);
    }
}(function ($) {
	//The standard screen sizes that bootstrap uses.
	var screenSizes = {
	    xs: 480,
	    sm: 768,
	    md: 992,
	    lg: 1200
	}
	var defaultOption = {
			logo:{
				min:'<b>Motor</b>',
				large:'<b>Motor</b>Platform'
			},
			showOffcanvas:true,
			offcanvas:'<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">'
					 +'<span class="sr-only">Toggle navigation</span>'
					 +'<span class="icon-bar"></span>'
					 +'<span class="icon-bar"></span>'
					 +'<span class="icon-bar"></span>'
					 +'</a>',
			showUserInfo:true,
			user:{
				name:'',
				portrait:''
			}
	};
	var createHeader = function(element){
		element.addClass('main-header');
		var _html = '<a href="javascript:void(0);" class="logo">'
			+ '<span class="logo-mini"><b>Motor</b></span>'
			+ '<span class="logo-lg"><b>Motor</b>Platform</span>'
			+ '</a>'
			+ '<nav class="navbar navbar-static-top" role="navigation">'
			+ '<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">'
			+ '<span class="sr-only">Toggle navigation</span>'
			+ '<span class="icon-bar"></span>'
			+ '<span class="icon-bar"></span>'
			+ '<span class="icon-bar"></span>'
			+ '</a>'
			+ '</nav>';
		element.html(_html);
	}
	
	var _createUserMenu = function(ul){
		var li = $('<li class="dropdown user user-menu"></li>').addClass('dropdown user user-menu');
		ul.append(li);
		var _html = '';
		
	}
    $.fn.Header = function (method) {
    	var methods = {
    			init : function(custumOption){
    					return this.each(function(){
    						createHeader($(this));
    						$('[data-toggle="offcanvas"]').on('click',function(e){
    							e.preventDefault();
    							//Enable sidebar push menu
    							debugger;
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
    			},
    			createMenu:function(options){
    				return this.each(function(){
    					var $this = $(this);
    					var div = $('<div class="navbar-custom-menu"><div>');
    					var ul = $('<ul class="nav navbar-nav">');
    					div.append(ul);
    					$this.append(div);
    					$.each(options['menus'],function(i,menu){
    						if(menu=='user'){
    							_createUserMenu();
    						}
    					});
    				});
    			}
    	};
    	if (methods[method]) {
            return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
        } else if (typeof method === 'object' || !method) {
            return methods.init.apply(this, arguments);
        } else {
            $.error('Method ' + method + ' does not exist on jQuery.MotorMenu');
        }
    };
}));