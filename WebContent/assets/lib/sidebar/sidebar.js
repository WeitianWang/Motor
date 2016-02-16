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
	var defaultOption = {
	};
	var methods = {
			init:function(custumOption){
				
			}
	};
    $.fn.SideBar = function (method) {
    	if (methods[method]) {
            return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
        } else if (typeof method === 'object' || !method) {
            return methods.init.apply(this, arguments);
        } else {
            $.error('Method ' + method + ' does not exist on jQuery.MotorMenu');
        }
    };
}));