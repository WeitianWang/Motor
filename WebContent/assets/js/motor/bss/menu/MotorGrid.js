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
	//默认设置
	var defaultOption = {
			url:null,//远程加载数据地址
			data:null,//初始化grid数据
			columns:null,//列名数组
			mClass:['table','table-bordered','table-hover','table-striped']//默认表格样式
		},
	_option = {},
	//创建thead
	createThead = function(columns,table){
		var thead = $('<thead></thead>');
		var tr = $('<tr></tr>');
		$.each(columns,function(i,column){
			var th = $('<th></th>');
			th.html(column['title']);
			th.appendTo(tr);
		});
		tr.appendTo(thead).appendTo(table);
	},
	createTr = function(data,columns,level){
		var r = '';
		$.each(data,function(i,row){
			var cls = '';
			if(level!=0){
				cls += ' hidden';
			}
			var tr = '<tr id="'+row['id']+'" pid="'+row['pid']+'" display="table-row" class="'+cls+'">';
			$.each(columns,function(i,c){
				var td = '<td>';
				var field = c.field,obj = row[field];
				if(field=='name'){
					var _htm = '<span class="'+row['icon']+' fa-lg"></span><span style="padding-left:10px;">'+obj+'</span>';
					if(row.children.length>0){
		        		_htm = '<span option="toggle" class="icon-caret fa fa-plus-square-o"></span>&nbsp;'+_htm;
		        	}
					if(row['pid']){
						 var style = 'margin-left:'+level*33+'px;';
		        		 _htm='<ul class="tree" style="'+style+'"><li class="tree-branch">'+_htm+'</li></ul>';
		        	}else{
		        		_htm='<span><span>'+_htm+'</span></span>';
		        	}
					td += _htm;
				}else{
					if(c['render']){
						td += c['render'](row);
					}else{
						td += obj;
					}
				}
				tr += td+'</td>';
			});
			tr += '</tr>';
			r += tr;
			if(row.children.length>0){
				r += createTr(row.children,columns,level+1);
			}
		});
		return r;
	}
	//创建tbody
	createTbody = function(data,table,columns){
		var h = createTr(data,columns,0);
		var tbody = '<tbody>'+h+'</tbody>';
		table.append($(tbody));
	},
	//加载数据
	loadData = function(url,data,table,columns){
		//优先加载远程数据
		if(url!=null){
			$.ajax({
				'url':url,
				'type':'POST',
				'dataType':'json',
				'success':function(data){
					createTbody(data,table,columns);
				}
			});
		}else{//加载本地数据
			if(data!=null&&(data instanceof Array)){
				createTbody(data,table,columns);
			}else{
				throw new Error('数据为空，或格式有误');
			}
		}
	},

	methods = {
			//初始化方法
			init:function(custumOption){
				_option = $.extend({},defaultOption,custumOption);
				return this.each(function(){
					var $this = $(this);
					var clazzs = _option['mClass'];
					var clazz = '';
					var url=_option['url'];
					var data = _option['data'];
					
					//内容置空
					$this.html(null);
					
					for(var i=0;i<clazzs.length;i++){
						clazz += clazzs[i]+' ';
					}
					//添加表格样式
					$this.addClass(clazz);
					
					//判断是否设置数据来源
					if(url==null&&data==null){
						throw new Error('请设置远程请求数据地址url，或设置本地数据data');
					}
					
					var columns = _option['columns'];
					//创建表头
					if(columns instanceof Array){
						createThead(columns,$this);
					}else{
						throw new Error('columns不是数组对象');
					}
					//加载数据
					loadData(url, data, $this,columns);
					
				});
			},
			appendRow:function(row,index){
				if(!index){
					_add(row,this);
				}
			},
			getRow:function(index){
				var tr = $('tr[motorGridIndex="'+index+'"]',this),row = tr.data('getRow');
				return row;
			}
	};
	
    $.fn.MotorGrid = function (method) {
    	if (methods[method]) {
            return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
        } else if (typeof method === 'object' || !method) {
            return methods.init.apply(this, arguments);
        } else {
            $.error('Method ' + method + ' does not exist on jQuery.MotorGrid');
        }
    };
}));