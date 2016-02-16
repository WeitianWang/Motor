var Common = {
		//js获取项目根路径，如： http://localhost:8000/System
		getBasePath:function(){
		    //获取当前网址，如： http://localhost:8000/System/main.jsp
		    var curWwwPath=window.document.location.href;
		    //获取主机地址之后的目录，如： System/UI/meun.jsp
		    var pathName=window.document.location.pathname;
		    var pos=curWwwPath.indexOf(pathName);
		    //获取主机地址，如： http://localhost:8000
		    var localhostPaht=curWwwPath.substring(0,pos);
		    //获取带"/"的项目名，如：/System
		    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
		    return(localhostPaht+projectName);
		},
		//浏览器视口的高度
		windowHeight:function(){
			var de = document.documentElement;
		    return self.innerHeight || (de && de.clientHeight) || document.body.clientHeight;
		},
		//浏览器视口的宽度
		widowWith:function(){
			var de = document.documentElement;
		    return self.innerWidth || (de && de.clientWidth) || document.body.clientWidth
		},
		//浏览器水平滚动位置 
		scrollX:function(){
			 var de = document.documentElement;
			 return self.pageXOffset || (de && de.scrollLeft) || document.body.scrollLeft;
		},
		//浏览器垂直滚动位置 
		scrollY:function(){
			 var de = document.documentElement;
			 return self.pageYOffset || (de && de.scrollTop) || document.body.scrollTop;
		},
		/**
		 * 构造无参函数
		 * @param obj
		 * @param strFunc
		 * @returns {Function}
		 */
		createFunction:function(obj,strFunc){
			var args=[];
			if(!obj)obj=window;
			for(var i=2;i<arguments.length;i++)args.push(arguments[i]);
			return function(){
				obj[strFunc].apply(obj,args);
			};
		},
		/**
		 * 非空判断
		 * @param str
		 * @returns {Boolean}
		 */
		notNull:function(str){
			return (str!=null)&&($.trim(str)!="");
		},
		/**
		 * 定位到页面中心
		 * @param id 元件ID
		 */
		fixedCenter:function(id){
			var w = $(id).width();
		    var h = $(id).height();
		    
		    var t = scrollY() + (windowHeight()/2) - (h/2);
		    if(t < 0) t = 0;
		    
		    var l = scrollX() + (windowWidth()/2) - (w/2);
		    if(l < 0) l = 0;
		    
		    $(id).css({left: l+'px', top: t+'px'});
		}
}


/**
 * 对Date的扩展，将 Date 转化为指定格式的String 
 * 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 * 例子：
 * (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
 * (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
 * @param pattern 格式化模式 
 * @returns {new Date}
 */
Date.prototype.Format = function(pattern){ 
  var o = {   
    "M+" : this.getMonth()+1,                 //月份   
    "d+" : this.getDate(),                    //日   
    "h+" : this.getHours(),                   //小时   
    "m+" : this.getMinutes(),                 //分   
    "s+" : this.getSeconds(),                 //秒   
    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
    "S"  : this.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(pattern))   
    pattern=pattern.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(pattern))   
  pattern = pattern.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return pattern;   
}  


/**
 * 数组最大值
 */
Array.max = function( array ){
    return Math.max.apply( Math, array );
};
/**
 * 数组最小值
 */
Array.min = function( array ){
    return Math.min.apply( Math, array );
};

