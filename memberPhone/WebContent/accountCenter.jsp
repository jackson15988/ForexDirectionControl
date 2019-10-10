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
<link rel="stylesheet" type="text/css" href="css/icon.css" />
<link href="dist/dialog.css" rel="stylesheet">
<script src="dist/mDialogMin.js"></script>



</head>
<body style="background-color: #fff;">
	<!--header star-->
	<div class="nheader nheadertwo clearfloat box-s" id="header">

		<a href="trader.jsp" class="fl"><i class="iconfont icongupiaoqiquan"></i></a>
		<p class="fl">帳戶中心</p>
		<a href="logout" class="fr"><i class="iconfont icondengchu"></i></a>
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
	var phoneNumber = '<%=phoneNumber %>';
	var mt4Account = '<%=mt4Account %>';
	
window.onload = function() {
	
	
	
	if(mt4Account  == "DefaultAccount"){	
		 Dialog.init('您尚未設定交易帳戶，請先設定在前往戰情中心!!',{
		        title : 'Error',
		        style : 'color:red;font-weight: bold;font-size:10px'
		    });
	}else{
	console.log('存在帳號');	
	findAccount();
	}
}


function updataMt4Account() {
	
	var accountStyle = $('#accountStyle').val();
	var mt4account = $('#mt4account').val();
	var user = {
		"phoneNumber" : phoneNumber,
		"accountStyle" : accountStyle,
		"mt4account" : mt4account
	};
	$.ajax({
		type : "POST",
		url : "/memberPhone/UpdataMt4Account",
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(user),
		success : function(data) {

			if (data.code == 0) {
				 Dialog.init('設定帳號成功!!',{
				        title : 'Success',
				        style : 'color:#0094de;font-weight: bold;font-size:10px'
				    });
			}
		},
		error : function(err) {
			alert('AJAX獲取數據失敗' + err);
		}
	});
}


function findAccount() {
// 	$("#mt4account").val(mt4Account);			

	
	var user = {
		"phoneNumber" : phoneNumber
	};
	$.ajax({
		type : "POST",
		url : "/memberPhone/FindUserMt4Account",
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(user),
		success : function(data) {

			if(data.mt4Account =="DefaultAccount"){
			$("#mt4account").val("");								
			}else{
			$("#mt4account").val(data.mt4Account);	
			$("#accountStyle").val(data.mt4AccountStyle);	
			
			}

		},
		error : function(err) {
			alert('AJAX獲取數據失敗' + err);
		}
	});
}

</script>
<script src="js/rem.js"></script>





