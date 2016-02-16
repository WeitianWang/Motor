;(function (factory) {
    if (typeof define === "function" && define.amd) {
        // AMD模式
        define([ "jquery" ], factory);
    } else {
        // 全局模式
        factory(jQuery);
    }
}(function ($) {
	var _buildMenu = function(parent,items){
		$.each(items,function(i,item){
			var li = $('<li id="'+item['id']+'"></li>');
			var clazz = item['clazz']==undefined?'fa':'fa '+item['clazz'];
			li.append('<li class="'+clazz+'"></li>').append('<span>'+item['name']+'</span>')
			
			//绑定菜单数据
			li.data('getMenuItem',item);
			alert();
			//debugger;
			parent.append(li);
			if(item['children']&&item['children'].length!=0){
				li.addClass('menu-list');
				var ul = $('<ul class="sub-menu-list"></ul>');
				li.append(ul);
				return _buildMenu(ul,item['children']);
			}
		});
	}
	var methods = {
			init:function(options){
				var items = options['data'];
				_buildMenu(this, items);
				return this;
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