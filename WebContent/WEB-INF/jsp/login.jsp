<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no, maximum-scale=1.0">
<title>Welcome to Motor platform</title>
<link rel="shortcut icon" type="text/css" href="<%=basePath %>assets/image/login/motor.png">
<link rel="stylesheet" type="text/css" href="<%=basePath %>assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>assets/css/login.css">
<script data-main="../assets/js/menu" src="../assets/js/require.js" defer async="true"></script>
</head>
<body class="login-body">
	<div class="container" >
		<form id="loginform" class="form-signin loginbox" method="post" role="form" action="./doLogin.do">
			<div class="form-signin-heading  text-center">
				<h2 class="title">Motor platform v1.0</h2>
				<img width="250" height="150" src="<%=basePath %>assets/image/motor.png" />
			</div>
			<div class="login-wrap">
					<input type="text" class="form-control" placeholder="User ID" autofocus>
					<input type="password" class="form-control" placeholder="Password">
				<button id="loginBtn" class="btn btn-lg btn-login btn-block">
				  登陆&nbsp;&nbsp;<li style="text-align: right;" class="glyphicon  glyphicon-log-in"></li> 
				</button>
				<label class="checkbox">
	                <input type="checkbox" value="remember-me"> Remember me
	                <span class="pull-right">
	                    <a> Forgot Password?</a>
	                </span>
	            </label>
			</div>
		</form>
	</div>
</body>
</html>