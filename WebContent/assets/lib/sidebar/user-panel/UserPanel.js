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
				this.addClass('user-panel');
				var _html = '<div class="pull-left image">'
						  + '<img src="../assets/theme/AdminLTE/img/IMG_1947.JPG" class="img-circle" alt="User Image">'
						  + '</div>'
						  + '<div class="pull-left info">'
						  + '<p>Alexander Pierce</p>'
						  + '<a href="#"><i class="fa fa-circle text-success"></i> Online</a>'
						  + '</div>';
				this.html(_html);
			}
	};
    $.fn.UserPanel = function (method) {
    	if (methods[method]) {
            return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
        } else if (typeof method === 'object' || !method) {
            return methods.init.apply(this, arguments);
        } else {
            $.error('Method ' + method + ' does not exist on jQuery.MotorMenu');
        }
    };
}));