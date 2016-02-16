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
			action:'#',
			method:'post'
	};
	var methods = {
			init:function(custumOption){
				this.addClass('sidebar-form');
				var _html = '<div class="input-group">'
						  + '<input type="text" name="q" class="form-control" placeholder="Search..."/>'
						  + '<span class="input-group-btn">'
						  + '<button type="submit" name="search" id="search-btn" class="btn btn-flat">'
						  + '<i class="fa fa-search"></i>'
						  + '</button>'
						  + '</span>'
						  + '</div>';
				this.html(_html);
			}
	};
    $.fn.MotorSearchForm = function (method) {
    	if (methods[method]) {
            return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
        } else if (typeof method === 'object' || !method) {
            return methods.init.apply(this, arguments);
        } else {
            $.error('Method ' + method + ' does not exist on jQuery.MotorMenu');
        }
    };
}));