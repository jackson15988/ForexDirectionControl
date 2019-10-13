package com.memberPhone.threadsgo;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.memberPhone.PhoneNewsletter;
import com.memberPhone.mirakeBo;



/**
 * 
 * @author IMI-JAVA-Ryan 此為傳送至客戶手機訊號的多執行續用法
 *
 */
public class mirakeSmsThread extends Thread {

	private HashMap<String, Object> batchArgsMaps;

	public void setBatchArgsMaps(HashMap<String, Object> batchArgsMaps) {
		this.batchArgsMaps = batchArgsMaps;
	}

	
	public void run() {
		
		
		
//		String chineseSymbolName = batchArgsMaps.get("OrderSymbol").toString();
//		String SymbolType =  batchArgsMaps.get("OrderType").toString();
		/* 這裡去組成下單資訊 */
		StringBuffer body = new StringBuffer();
		body.append("歡迎使用外匯MT4系統，您的Sniper系統認證碼 :  "  +  batchArgsMaps.get("SMSAuthenticationCode"));
		String messageContents = body.toString();
//		String messageTransferNumber = (String) batchArgsMaps.get("OrderTicket");
		// 取得三竹資訊的證券
		HashMap<String, Object> mitakLoginVal = new HashMap<>();
		try {

			
			mitakLoginVal = mirakeBo.getMitakeSettingVal();
			PhoneNewsletter phletter = new PhoneNewsletter();
			// 傳送三竹簡訊給客戶
			System.out.println("客戶接收到的訊息:" + messageContents);
			phletter.MT4oederSMSMessage(messageContents, batchArgsMaps , mitakLoginVal);
			
		} catch (SQLException e) {
			System.out.println("資料發生錯誤:" + e);
		}

	}

	

	

}
