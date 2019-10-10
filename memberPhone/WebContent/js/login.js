//	取得驗證碼 使用的邏輯區域
function checkloginInformation() {

	var phoneNumber = $('#phoneNumber').val();
	var password  = $('#password').val();
	var user = {
			"phoneNumber" : phoneNumber,
			"password" : password
	};
	$.ajax({
		type : "POST",
		url : "/memberPhone/CheckloginInformation",
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(user),
		success : function(data) {

			if (data.code == 0) {
				 Dialog.init('登入成功請稍後!!',{
				        title : 'Success',
				        style : 'color:#0094de;font-weight: bold;font-size:10px'
				    });
				window.location = "/memberPhone/trader.jsp";
			}else{
				alert(data.message);
			}
		},
		error : function(err) {
			alert('AJAX獲取數據失敗' + err);
		}
	});

}

