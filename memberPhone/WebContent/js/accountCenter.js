//	取得驗證碼 使用的邏輯區域
function updataMt4Account() {
	
	var phoneNumber = $("#phoneNumber").val();
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
				alert('取得驗證碼成功!');
			}
		},
		error : function(err) {
			alert('AJAX獲取數據失敗' + err);
		}
	});

}





