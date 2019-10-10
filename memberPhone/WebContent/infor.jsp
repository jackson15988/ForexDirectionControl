<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
	String obk = session.getAttribute("Account") == null ? "" : session.getAttribute("Account").toString();
	String isLogin = session.getAttribute("isLgoin") == null ? "" : session.getAttribute("isLgoin").toString();
	if (isLogin.equals("Y") && !obk.isEmpty()) {
		System.out.print("有效登入");
	} else {
		System.out.print("無效登入");
		response.sendRedirect("login.jsp");
	}
%>

<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no">
<title>注册</title>
<meta name="keywords" content="">
<meta name="description" content="">
<script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="js/jquery.SuperSlide.2.1.js" type="text/javascript"></script>
<script src="js/hmt.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/pages.css" />
<link rel="stylesheet" type="text/css" href="css/mui.min.css" />
<script src="js/register.js"></script>
</head>

<body style="background-color: #fff;">
	<div></div>
	<!--header star-->
	<div class="nheader nheadertwo clearfloat box-s" id="header">
		<a href="javascript:history.go(-1)" class="fl">返回
		</a>
		<p class="fl">設定登入密碼</p>
		<a href="sign.html" class="fr"> 登录 </a>
	</div>
	<!--header end-->

	<!--register star-->
	<div class="register clearfloat" id="main">
		<div class="reg-top clearfloat box-s">
			<div class="top clearfix">
				<samp class="line db"></samp>
				<samp class="curline db"></samp>
				<ul>
					<li class="fl">
						<div class="shu cur clearfix box-s">
							<span class="cur"> 1 </span>
						</div>
						<p class="cur">注册账号</p>
					</li>
					<li class="fl">
						<div class="shu cur clearfix box-s">
							<span class="cur"> 2 </span>
						</div>
						<p class="cur">信息填写</p>
					</li>
					<li class="fl">
						<div class="shu clearfix box-s">
							<span> 3 </span>
						</div>
						<p>用户登录</p>
					</li>
				</ul>
			</div>
		</div>
		<span class="huibg"></span>
		<div class="sign-top clearfloat">
			<ul>
				<li class="box-s"><input type="password" name="" id="password" value=""
					class="mingzi" placeholder="请输入密码" /></li>
				<li class="box-s"><input type="password" name="" id="checkpassword" value=""
					class="mingzi" placeholder="请再次输入密码" /></li>
			</ul>
		</div>
		<a href="#" class="sign-btn sign-btntwo" onclick="settingPassword()">下一步</a>
	</div>
	<!--register end-->
</body>
</html>
<script src="js/rem.js"></script>
