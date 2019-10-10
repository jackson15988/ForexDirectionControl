<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
		<title>登录</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<script src="js/rem.js"></script>
		<script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
		<script src="js/jquery.SuperSlide.2.1.js" type="text/javascript"></script>
		<script src="js/hmt.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="css/base.css" />
		<link rel="stylesheet" type="text/css" href="css/pages.css" />
		<link rel="stylesheet" type="text/css" href="css/pages.css" />
		<link rel="stylesheet" type="text/css" href="css/icon.css" />
<!-- 		 <link rel="stylesheet" href="http://at.alicdn.com/t/font_923612_bsbnso2jta.css"> -->

	
		<script src="js/login.js"></script>
		<link href="dist/dialog.css" rel="stylesheet">
		<script src="dist/mDialogMin.js"></script>
	</head>
	
	<body style="background-color: #fff;">
		<!--header star-->
		<div class="nheader nheadertwo clearfloat box-s" id="header">
			<a href="register.jsp" class="fl">
			<i class="iconfont iconshangyiye"></i>
			</a>
			<p class="fl">
				登入
			</p>
			<a href="register.jsp" class="fr">
				<i class="iconfont iconzhuce1"></i>
			</a>
		</div>
		<!--header end-->
		
		<!--sign star-->
		<div class="sign clearfloat" id="main">
			<div class="sign-top clearfloat">
				<ul>
					<li class="box-s">
						<input type="text" name="" id="phoneNumber" value="" class="mingzi" placeholder="请输入您的手機號碼 "/>
					</li>
					<li class="box-s">
						<input type="password" name="" id="password" value="" class="mingzi" placeholder="请输入您的密码" />
					</li>
				</ul>
			</div>
			<div class="mima clearfloat box-s">
				<ul>
					<li class="fl">
						<div class="xuan clearfloat fl">
		    				<div class="radio"> 
							    <label>
							        <input type="checkbox" name="sex" value="">
							        <div class="option"></div>
							        <span class="opt-text">记住密码</span>
							    </label>
							</div>
		    			</div>
					</li>
					<li class="fr wangji">
						<a href="#">忘记密码？</a>
					</li>
				</ul>
			</div>
			<a href="#" class="sign-btn" onclick="checkloginInformation()">登录</a>
			<div class="bottom clearfloat">
				<div class="shang clearfloat">
					<span class="line"></span>
					<span class="nr">第三方登录</span>
				</div>
				<div class="xia clearfloat">
					<ul>
						<li class="fl">
							<i class="iconfont icongoogle" id="icongoogle"></i>
							<p>谷歌</p>
						</li>
						<li class="fl">
							<i class="iconfont iconQQ" id="iconQQ"></i>
							<p>QQ</p>
						</li>
						<li class="fl">
							<i class="iconfont iconzhifubao"  id="iconzhifubao"></i>
							<p>支付宝</p>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!--sign end-->
	</body>
</html>