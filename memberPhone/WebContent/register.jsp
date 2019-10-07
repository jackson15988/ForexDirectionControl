<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<script src="js/register.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/pages.css" />
<link rel="stylesheet" type="text/css" href="css/mui.min.css" />
</head>
<body style="background-color: #fff;">
	<!--header star-->
	<div class="nheader nheadertwo clearfloat box-s" id="header">
		<a href="javascript:history.go(-1)" class="fl"> <i
			class="iconfont icon-fanhui"></i>
		</a>
		<p class="fl">注册</p>
		<a href="login.jsp" class="fr"> 登录 </a>
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
				<li class="box-s">
				<input type="text" name="" id="phoneNumber" value="" class="mingzi" placeholder="輸入手机号" /></li>
				<li class="box-s">
				<input type="text" name="" id="verificationCode" value="" class="mingzi yzm fl" placeholder="输入验证码" /> 
				<input type="submit" name="" id="" value="获取验证码" class="huoqu fr" onclick="getVerificationCode();"/></li>
<!-- 				<li class="box-s"> -->
<!-- 					<p> -->
<!-- 						帳戶種類<select  id="accountStyle" style="width: 60%"> -->
<!-- 							<option value="1">真實帳號</option> -->
<!-- 							<option value="0">模擬帳號</option> -->
<!-- 						</select> -->
<!-- 					</p> -->
<!-- 				</li> -->
<!-- 				<li class="box-s"><input type="text" name="" id="mt4account" value="" -->
<!-- 					class="mingzi yzm fl" placeholder="MT4交易帳號" /></li> -->
			</ul>
		</div>
		<a href="#" class="sign-btn sign-btntwo" onclick="registerMember()">下一步</a>
	</div>
	<!--register end-->
</body>
</html>
<script src="js/rem.js"></script>
