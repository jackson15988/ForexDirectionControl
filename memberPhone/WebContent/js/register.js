//	取得驗證碼 使用的邏輯區域
function getVerificationCode() {

	var phonenumber = $('#phoneNumber').val();
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
				alert('取得驗證碼成功!');
			}
		},
		error : function(err) {
			alert('AJAX獲取數據失敗' + err);
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
			alert('您輸入的帳號兩次不相符合!!');
		}
	} else {
		alert('登入密碼與確認密碼不得為空值!!');
	}
}
