$(function(){
	//登陆按钮绑定点击事件
	$("#loginBtn").bind("click",function(){
		if(verify()){
			login();
		}
	});
	
});

function verify(){
	if(!Common.notNull($('#username').val())){
		alert('用户名不能为空！');
		return false;
	}
	if(!Common.notNull($('#password').val())){
		alert('密码不能为空！');
		return false;
	}
	return true;
}

function login(){
	var username = $("#username").val();
	var password = $("#password").val();
	$.ajax({
		url : Common.getBasePath() + '/authenticate.do',
		type : 'post', //数据发送方法
		data : {"username":username,"password":password},
		dataType : 'text', //接受数据格式 
		cache : false,
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("not lived!" + XMLHttpRequest + "-" + textStatus + "-" + errorThrown);
		},
		success : function(data, textStatus) {
			if("true" == data){
				var form = $("#loginform");
				form.attr("action",Common.getBasePath()+ "/authorize.do");
				form.submit();
			}
		}
	});
}
/**
 * 生成用户名输入框和密码输入框前面的小图标
 */
function drawIcon(){
	//定义画布
	var paper = new Raphael("userIcon",30,30);
	//定义用户icon路径
	var path = "M28.523,23.813c-0.518-0.51-6.795-2.938-7.934-3.396c-1.132-0.451-1.584-1.697-1.584-1.697s-0.51,0.282-0.51-0.51c0-0.793,0.51,0.51,1.021-2.548c0,0,1.414-0.397,1.133-3.68l-0.338,0.001c0,0,0.85-3.511,0-4.699c-0.854-1.188-1.188-1.981-3.062-2.548c-1.869-0.567-1.188-0.454-2.547-0.396c-1.359,0.057-2.492,0.793-2.492,1.188c0,0-0.849,0.057-1.188,0.397c-0.34,0.34-0.906,1.924-0.906,2.32s0.283,3.059,0.566,3.624l-0.337,0.112c-0.283,3.283,1.132,3.681,1.132,3.681c0.509,3.058,1.019,1.755,1.019,2.548c0,0.792-0.51,0.51-0.51,0.51s-0.452,1.246-1.584,1.697c-1.132,0.453-7.416,2.887-7.927,3.396c-0.511,0.521-0.453,2.896-0.453,2.896h12.036l0.878-3.459l-0.781-0.781l1.344-1.344l1.344,1.344l-0.781,0.781l0.879,3.459h12.035C28.977,26.709,29.039,24.332,28.523,23.813z";
	//画出用户icon
	var userIcon = paper.path(path).attr({fill: "#369AEC", stroke: "none"});
	//icon缩放0.8倍
	userIcon.transform("s0.8...");
	//定义密码icon路径
	path = "M24.875,15.334v-4.876c0-4.894-3.981-8.875-8.875-8.875s-8.875,3.981-8.875,8.875v4.876H5.042v15.083h21.916V15.334H24.875zM10.625,10.458c0-2.964,2.411-5.375,5.375-5.375s5.375,2.411,5.375,5.375v4.876h-10.75V10.458zM18.272,26.956h-4.545l1.222-3.667c-0.782-0.389-1.324-1.188-1.324-2.119c0-1.312,1.063-2.375,2.375-2.375s2.375,1.062,2.375,2.375c0,0.932-0.542,1.73-1.324,2.119L18.272,26.956z";
	//重新定义画布
	paper = new Raphael("passwordIcon",30,30);
	//画出密码icon
	var passwordIcon = paper.path(path).attr({fill: "#369AEC", stroke: "none"});
	//icon缩放0.7倍
	passwordIcon.transform("s0.7...");
}