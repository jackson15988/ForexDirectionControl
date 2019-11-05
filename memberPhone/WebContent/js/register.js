document.write("<script language='javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js' ></script>");


//	取得驗證碼 使用的邏輯區域
function getVerificationCode() {

	var phonenumber = $('#phoneNumber').val();
	
	if(phonenumber == ""){
		    Dialog.init('手機號碼不得為空',{
		        title : 'Error',
		        style : 'color:red;font-weight: bold;font-size:10px'
		    });
		
		return;
	}
	var user = {
		"phonenumber" : phonenumber
	};
	$.ajax({
		type : "POST",
		url : "/memberPhone/GetverificationCode",
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(user),
		success : function(data) {

			if (data.code == 0) {
				
				 Dialog.init('取得驗證碼成功!!',{
				        title : 'Success',
				        style : 'color:#0094de;font-weight: bold;font-size:10px'
				    });
				 
			     
			}
			   $.cookie("total", 300);
		        timekeeping();
		},
		error : function(err) {
		    Dialog.init('AJAX動態數據交換失敗',{
		        title : 'Error',
		        style : 'color:red;font-weight: bold;font-size:10px'
		    });
		}
	});

}

function registerMember() {

	var phonenumber = $('#phoneNumber').val();
	var verificationCode = $('#verificationCode').val();
	// var accountStyle = $('#accountStyle').val();
	// var mt4account = $('#mt4account').val();
	
	if(phonenumber == "" || verificationCode == "" ){
		   Dialog.init('驗證碼與手機號碼不得為空字符串!!',{
		        title : 'Error',
		        style : 'color:red;font-weight: bold;font-size:10px'
		    });
		   
		   return;
	}
	
	var user = {
		"phonenumber" : phonenumber,
		"verificationCode" : verificationCode
	// "accountStyle" : accountStyle,
	// "mt4account" : mt4account
	};
	$.ajax({
		type : "POST",
		url : "/memberPhone/RegisterAdmSystemMember",
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(user),
		success : function(data) {

			if (data.code == 0) {
				 Dialog.init('驗證成功!!',{
				        title : 'Success',
				        style : 'color:#0094de;font-weight: bold;font-size:10px'
				    });
				
				window.location = "/memberPhone/infor.jsp";
			}else{
				 Dialog.init('驗證失敗!!',{
				        title : 'Error',
				        style : 'color:red;font-weight: bold;font-size:10px'
				    });
				
			}
		},
		error : function(err) {
			alert('AJAX獲取數據失敗' + err);
		}
	});

}

function timekeeping() {
    //把按鈕設置為不可以點擊
    $("#btn").attr("disabled", true);
    var interval = setInterval(function() { //每秒讀取一次cookie
        //從cookie 中讀取剩余倒計時
        total = $.cookie("total");
        //存入Cookie 防止頁面刷新
        //在發送按鈕顯示剩余倒計時
        $("#btn").val("請等待" + total + "秒");
        //把剩余總倒計時減掉1
        total--;
        if (total == 0) { //剩余倒計時為零，則顯示 重新發送，可點擊
            //清除定時器
            clearInterval(interval);
            //刪除cookie
            total = $.cookie("total", total, {
                expires: -1
            });
            //顯示重新發送
            $("#btn").val("重新發送");
            //把發送按鈕設置為可點擊
            $("#btn").attr("disabled", false);
        } else { //剩余倒計時不為零
            //重新寫入總倒計時
            $.cookie("total", total);
        }
    }, 1000);
}




    $(function() {
        if ($.cookie("total") != undefined && $.cookie("total") != "NaN" && $.cookie("total") != "null") {
            timekeeping();
        } else {
            $("#btn").attr("disabled", false);
        }
    }); 

function settingPassword() {
	var password = $('#password').val();
	var checkpassword = $('#checkpassword').val();
	if (checkpassword != "" && password != "") {
		if (password == checkpassword) {
			var user = {
				"password" : password,
				"checkpassword" : checkpassword
			// "accountStyle" : accountStyle,
			// "mt4account" : mt4account
			};
			$.ajax({
				type : "POST",
				url : "/memberPhone/SettingPassword",
				dataType : "json",
				contentType : "application/json",
				data : JSON.stringify(user),
				success : function(data) {
					if (data.code == 0) {
						window.location = "/memberPhone/infor.jsp";
					}
				},
				error : function(err) {
					alert('AJAX獲取數據失敗' + err);
				}
			});
		} else {
			
			  Dialog.init('您輸入的帳號兩次不相符合!!',{
			        title : 'Error',
			        style : 'color:red;font-weight: bold;font-size:10px'
			    });
		}
	} else {

		
		  Dialog.init('登入密碼與確認密碼不得為空字符!!',{
		        title : 'Error',
		        style : 'color:red;font-weight: bold;font-size:10px'
		    });
	}
}
