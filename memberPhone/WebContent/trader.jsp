<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no">
<title>外匯MT4分享社</title>
<meta name="keywords" content="">
<meta name="description" content="">
<script src="js/rem.js"></script>
<script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="js/jquery.SuperSlide.2.1.js" type="text/javascript"></script>
<script src="js/hmt.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/pages.css" />
<link rel="stylesheet" type="text/css" href="css/mui.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://libs.useso.com/js/font-awesome/4.2.0/css/font-awesome.min.css">



<link href="dist/dialog.css" rel="stylesheet">
</head>
<script src="dist/mDialogMin.js"></script>

<style>
* {
	margin: 0;
	padding: 0;
	font-family: "开心软件少儿简体", "方正少儿简体", "迷你简少儿", "方正少儿_gbk", sans-serif
}

.mDialogs {
	display: inline-block;
	padding: 0 20px;
	text-decoration: none;
	outline: none;
	margin: 20px 10px;
	background: #222;
	color: #fff;
	line-height: 40px;
	text-align: center
}

.dialog_load2.c_alert_wrap {
	background: none;
	box-shadow: none
}

.dialog_load.c_alert_wrap {
	background: none;
}

.dialog_load .c_alert_con {
	background: rgba(0, 0, 0, .7);
	padding: 24px 25px
}

.c_alert_con img {
	vertical-align: top
}
</style>





</head>

<body>
	<!--header star-->
	<div class="nheader nheadertwo clearfloat box-s" id="header">
		<a href="" class="fl"> <i class="fa fa-home fa-fw"></i>

		</a>
		<p class="fl">戰情中心</p>
		<a href="register.html" class="fr"> 登出 </a>
	</div>
	<!--header end-->

	<!--container star-->
	<div class="header-menu" id="">



		<div class="content clearfloat" id="butdiv">
			<!-- 				<div class="three box-s"> -->
			<!-- 					<div class="shang clearfloat box-s"> -->
			<!-- 						<ul> -->
			<!-- 							<li class="over">商品</li> -->
			<!-- 							<li>多方</li>	 -->
			<!-- 							<li>中立</li> -->
			<!-- 							<li>空方</li> -->
			<!-- 							<li>狀態</li> -->
			<!-- 						</ul> -->
			<!-- 					</div> -->
			<div class="list clearfloat box-s">
				<ul>
					<li class="over">EURUSD</li>
					<li><a href="tender-detail.html" class="cowMarkst">牛市</a></li>
					<li><a href="tender-detail.html" class="centerMarkets">中立</a></li>
					<li><a href="tender-detail.html" class="bearMarkets">熊市</a></li>
					<li><img src="images/588.jpg" height=30 width=43></img></li>
				</ul>
			</div>


			<div class="list clearfloat box-s">
				<ul>
					<li class="over">GBPUSD</li>
					<li><a href="tender-detail.html" class="cowMarkst">牛市</a></li>
					<li><a href="tender-detail.html" class="centerMarkets">中立</a></li>
					<li><a href="tender-detail.html" class="bearMarkets">熊市</a></li>
					<li><img src="images/589.jpg" height=30 width=43></img></li>
				</ul>
			</div>





			<div class="list clearfloat box-s">
				<ul>
					<li class="over">AUDUSD</li>
					<li><a href="tender-detail.html" class="cowMarkst">牛市</a></li>
					<li><a href="tender-detail.html" class="centerMarkets">中立</a></li>
					<li><a href="tender-detail.html" class="bearMarkets">熊市</a></li>
					<li><img src="images/559.jpg" height=30 width=43></img></li>
				</ul>
			</div>


			<div class="list clearfloat box-s">
				<ul>
					<li class="over">AUDJPY</li>
					<li><a href="tender-detail.html" class="cowMarkst">牛市</a></li>
					<li><a href="tender-detail.html" class="centerMarkets">中立</a></li>
					<li><a href="tender-detail.html" class="bearMarkets">熊市</a></li>
					<li></li>
				</ul>
			</div>




			<div class="list clearfloat box-s">
				<ul>
					<li class="over">EURGBP</li>
					<li><a href="tender-detail.html" class="cowMarkst">牛市</a></li>
					<li><a href="tender-detail.html" class="centerMarkets">中立</a></li>
					<li><a href="tender-detail.html" class="bearMarkets">熊市</a></li>
					<li></li>
				</ul>
			</div>





			<div class="list clearfloat box-s">
				<ul>
					<li class="over">EURJPY</li>
					<li><a href="tender-detail.html" class="cowMarkst">牛市</a></li>
					<li><a href="tender-detail.html" class="centerMarkets">中立</a></li>
					<li><a href="tender-detail.html" class="bearMarkets">熊市</a></li>
					<li></li>
				</ul>
			</div>

		</div>
	</div>
	</div>
	<!--container end-->

	<!--footer star-->
	<!-- 		<div class="footer" id="footer"> -->
	<!-- 			<ul> -->
	<!-- 				<li> -->
	<!-- 					<a href="index.html"> -->
	<!-- 						<i class="iconfont icon-02"></i> -->
	<!-- 						<p>行业动态</p> -->
	<!-- 					</a> -->
	<!-- 				</li> -->
	<!-- 				<li> -->
	<!-- 					<a href="market.html"> -->
	<!-- 						<i class="iconfont icon-fankuihangqing"></i> -->
	<!-- 						<p>价格行情</p> -->
	<!-- 					</a> -->
	<!-- 				</li> -->
	<!-- 				<li class="cur"> -->
	<!-- 					<a href="tender.html"> -->
	<!-- 						<i class="iconfont icon-jiaoyi"></i> -->
	<!-- 						<p>交易</p> -->
	<!-- 					</a> -->
	<!-- 				</li> -->
	<!-- 				<li> -->
	<!-- 					<a href="service.html"> -->
	<!-- 						<i class="iconfont icon-fuwu-copy"></i> -->
	<!-- 						<p>服务</p> -->
	<!-- 					</a> -->
	<!-- 				</li> -->
	<!-- 				<li> -->
	<!-- 					<a href="sign.html"> -->
	<!-- 						<i class="iconfont icon-wode"></i> -->
	<!-- 						<p>我的</p> -->
	<!-- 					</a> -->
	<!-- 				</li> -->
	<!-- 			</ul> -->
	<!-- 		</div> -->
	<!--footer end-->
</body>
<script type="text/javascript">
	jQuery(".header-menu").slide({
		titCell : ".top li",
		mainCell : ".content",
		delayTime : 0
	});

	window.onload = function() {
		loadingData();
	}

	function loadingData() {
		$("#butdiv").empty();

		var user = {
			"mt4Account" : "2090388471",
			"industry" : 1,
			"corporation" : "hust"
		};
		$
				.ajax({
					type : "POST",
					url : "/memberPhone/TreaderControllerServlet",
					dataType : "json",
					contentType : "application/json",
					data : JSON.stringify(user),
					success : function(data) {
						var id = data.id;
						var mt4Account = data.mt4Account;
						var str = "";

						str += "<div class='three box-s'><div class='shang clearfloat box-s'><ul><li class='over'>商品</li><li>多方</li><li>中立</li>";
						str += "	<li>空方</li><li>狀態</li></ul></div>";

						for ( var key in data) {

							if (key.includes("symbol")) {
								var keyVal = data[key];
								key = key.replace("symbol_", "");
								key = key.toUpperCase();

								str += "<div class='list clearfloat box-s'><ul>";
								str += "<li class='over'>" + key + "</li>";
								str += "<li><a href='#' class='cowMarkst' id='cowMarkst'  onclick='return direction(&quot;"
										+ key + "_1&quot;);'>牛市</a></li>";
								str += "<li><a href='#' class='centerMarkets' onclick='return direction(&quot;"
										+ key + "_0&quot;);'>中立</a></li>";
								str += "<li><a href='#' class='bearMarkets' onclick='return direction(&quot;"
										+ key + "_2&quot;);'>熊市</a></li>";

								if (keyVal == '2') { // 空方
									str += "<li><img  src='images/588.jpg' class='statusImagnes_"+key+"' height=30 width=43 ></img></li></ul></div>";
								} else if (keyVal == '1') { //多方
									str += "<li><img src='images/589.jpg' class='statusImagnes_"+key+"' height=30 width=43 ></img></li></ul></div>";
								} else if (keyVal == '0') { //不啟動
									str += "<li><img src='images/559.jpg' class='statusImagnes_"+key+"' height=30 width=43 ></img></li></ul></div>";
								}
								console.log('取得參數:' + keyVal);

							}
						}
						$("#butdiv").append(str);

					},
					error : function(err) {
						alert('AJAX獲取數據失敗' + err);
					}
				});

		// 			$('#trhead').append(str);
	}

	function direction(key) {
		var user = {
			"mt4Account" : "2090388471",
			"direction" : key,
			"corporation" : "hust"
		};
		$.ajax({
			type : "POST",
			url : "/memberPhone/TreaderControlDirection",
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(user),
			success : function(data) {
			

				  Dialog.init('<img src="dist/load3.gif" width="48px"/>',{
					    mask : 0,
					    addClass : 'dialog_load',
					    time : 5,
					    after : function(){
					        Dialog.init('設定成功！',500);
					    }
					});
				   
				var keyC = key.substring(0, key.length - 2);
				if (key.indexOf(1) > 0) {
					$(".statusImagnes_" + keyC + "").attr("src",
							"images/589.jpg");
				} else if (key.indexOf(2) > 0) {
					$(".statusImagnes_" + keyC + "").attr("src",
							"images/588.jpg");
				} else if (key.indexOf(0) > 0) {
					$(".statusImagnes_" + keyC + "").attr("src",
							"images/559.jpg");
				}

			},
			error : function(err) {
				alert('AJAX獲取數據失敗' + err);
			}
		});

	}
</script>


</html>