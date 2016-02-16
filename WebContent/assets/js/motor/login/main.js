require.config({
	baseUrl: '../assets/js',
	paths:{
		'jquery':'jquery'
	}
});

require(['jquery'],function($){
	$(function(){
		alert('jquery is loaded');
	});
});
