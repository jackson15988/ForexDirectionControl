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
				window.location = "/memberPhone/infor.jsp";
			}
		},
		error : function(err) {
			alert('AJAX獲取數據失敗' + err);
		}
	});

}

function settingPassword() {
	var password = $('#password').val();
	var checkpassword = $('#checkpassword').val();
	if (checkpassword != null && password != null) {
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
