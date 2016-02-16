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
	//创建菜单
	var _buildMenu = function(parent,items,topLevel){
		$.each(items,function(i,item){
			var li = $('<li>');
			if(topLevel){
				li.addClass('treeview');
			}
			var a = $('<a href="javascript:void(0)" id="'+item['id']+'"></a>')
			var clazz = item['clazz']==undefined?'fa':'fa '+item['clazz'];
			a.html('<li class="'+clazz+'"></li><span>'+item['name']+'</span>');
			//绑定菜单数据
			a.data('getMenuItem',item);
			
			li.append(a);
			
			parent.append(li);
			
			if(item['children']&&item['children'].length!=0){
				a.append($('<i class="fa fa-angle-left pull-right">'));
				var ul = $('<ul class="treeview-menu"></ul>');
				li.append(ul);
				return _buildMenu(ul,item['children'],false);
			}
		});
	};
	//默认设置
	var defaultOption = {
			data:null,//初始化菜单数据，必须为良好的JSON格式，包括以下几个属性:id,name,children,clazz
			speed:200,//菜单收起展开速度
			onClick:function(menu){}//默认点击事件
	}

	var methods = {
			//初始化方法
			init:function(custumOption){
				return this.each(function(){
					var opt = $.extend({},defaultOption,custumOption);
					var items = opt['data'];
					var $this = $(this);
					//创建菜单
					_buildMenu($this, items,true);
					//添加单击事件监听
					$(document).on('click','#'+$this.attr('id')+' li a',function(){
						var d = $(this),e = d.next();
						if(e.is(".treeview-menu") && e.is(":visible")){
							e.slideUp(opt['speed'],function() {
								e.removeClass("menu-open")
							});
							e.parent("li").removeClass("active");
						}else if (e.is(".treeview-menu") && !e.is(":visible")) {
							var f = d.parents("ul").first(),
							g = f.find("ul:visible").slideUp(opt['speed']);
							g.removeClass("menu-open");
							var h = d.parent("li");
							e.slideDown(opt['speed'],function() {
								e.addClass("menu-open"),
								f.find("li.active").removeClass("active"),
								h.addClass("active")
							});
						}
						//调用单击事件
						opt['onClick']($(this).data('getMenuItem'));
					});
				});
			}
	};
	
    $.fn.MotorMenu = function (method) {
    	if (methods[method]) {
            return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
        } else if (typeof method === 'object' || !method) {
            return methods.init.apply(this, arguments);
        } else {
            $.error('Method ' + method + ' does not exist on jQuery.MotorMenu');
        }
    };
}));