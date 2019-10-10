<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	String isLogin = request.getSession().getAttribute("isLgoin") == null
			? ""
			: request.getSession().getAttribute("isLgoin").toString();
	String phoneNumber = request.getSession().getAttribute("Account") == null
			? ""
			: request.getSession().getAttribute("Account").toString();
	String permissionLogin = request.getSession().getAttribute("permissionLogin") == null
			? ""
			: request.getSession().getAttribute("permissionLogin").toString();
	String mt4Account = request.getSession().getAttribute("mt4Account") == null
			? ""
			: request.getSession().getAttribute("mt4Account").toString();
	if (isLogin.equals("Y") && permissionLogin.equals("Y")) {
		
	} else {
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
<script src="js/accountCenter.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/pages.css" />
<link rel="stylesheet" type="text/css" href="css/mui.min.css" />

<link href="dist/dialog.css" rel="stylesheet">
<script src="dist/mDialogMin.js"></script>



</head>
<body style="background-color: #fff;">
	<!--header star-->
	<div class="nheader nheadertwo clearfloat box-s" id="header">

		<a href="trader.jsp" class="fl"> 戰情中心</a>
		<p class="fl">帳戶中心</p>
		<a href="login.jsp" class="fr"> 登出</a>
	</div>
	<!--header end-->

	<!--register star-->
	<div class="register clearfloat" id="main">

		<span class="huibg"></span>
		<div class="sign-top clearfloat">
			<ul>
			
				<li class="box-s"><input type="text" name="" id="phoneNumber"
					value="" class="mingzi yzm fl" value=""  style="visibility:hidden"/></li>
				<li class="box-s">
					<p>
						帳戶種類<select id="accountStyle" style="width: 60%">
							<option value="1">真實帳號</option>
							<option value="0">模擬帳號</option>
						</select>
					</p>
				</li>
				<li class="box-s"><input type="text" name="" id="mt4account"
					value="" class="mingzi yzm fl" placeholder="輸入您的MT4交易帳號" /></li>
			</ul>
		</div>
		<a href="#" class="sign-btn sign-btntwo" onclick="updataMt4Account()">一鍵申請</a>
	</div>
	<!--register end-->
</body>
</html>


<script>
window.onload = function() {
	var phoneNumber = '<%=phoneNumber %>';
	var mt4Account = '<%=mt4Account %>';
	
	if(mt4Account  == "DefaultAccount"){
		alert('您尚未設定交易帳戶，請先設定在前往戰情中心');
	}else{
	console.log('存在帳號');		
	$("#mt4account").val(phoneNumber);				

	}
	

}
</script>
<script src="js/rem.js"></script>





