package com.memberPhone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alibaba.fastjson.JSON;
import com.memberPhone.Pojo.settingTreaderPojo;

public class GetTraderSettingDAO {

	public static void main(String[] args) throws SQLException {

		GetTraderSettingDAO.getTraderSetting("2090388471");
	}

	public static settingTreaderPojo getTraderSetting(String mt4Account) throws SQLException {

		Connection conn = null;
		Statement stmt = null;

		// 連接MySQL
		settingTreaderPojo settingPojo = new settingTreaderPojo();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// System.out.println("連接成功MySQLToJava");
			// 建立讀取資料庫 (test 為資料庫名稱; user 為MySQL使用者名稱; passwrod 為MySQL使用者密碼)
			String datasource = "jdbc:mysql://45.32.49.87:3306/myforex?user=root&password=36f57bc6fd&useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
			// 以下的資料庫操作請參考本blog中: "使用 Java 連結與存取 access 資料庫 (JDBC)"
			conn = DriverManager.getConnection(datasource);
			System.out.println("連接成功MySQL");
			stmt = conn.createStatement();
			String sql = "SELECT * FROM fo_admsystem  WHERE MT4_ACCOUNT='" + mt4Account + "';";
			ResultSet result = stmt.executeQuery(sql);
			int rowCount = result.getRow();

			if (rowCount == 0) {
				System.out.println("查詢不到任何資訊:");
			}
			if (result.next()) {

				settingPojo.setId(result.getInt(1));
				settingPojo.setMt4Account(result.getString("MT4_ACCOUNT"));
				settingPojo.setCustMemberId(result.getString("CUSTOMER_ID"));
				settingPojo.setSymbol_audjpy(result.getString("AUDJPY"));
				settingPojo.setSymbol_audnzd(result.getString("AUDNZD"));
				settingPojo.setSymbol_audusd(result.getString("AUDUSD"));
				settingPojo.setSymbol_cadjpy(result.getString("CADJPY"));
				settingPojo.setSymbol_euraud(result.getString("EURAUD"));
				settingPojo.setSymbol_eurcad(result.getString("CADJPY"));
				settingPojo.setSymbol_eurgbp(result.getString("EURGBP"));
				settingPojo.setSymbol_eurjpy(result.getString("EURJPY"));
				settingPojo.setSymbol_eurnzd(result.getString("EURNZD"));
				settingPojo.setSymbol_eurusd(result.getString("EURUSD"));
				settingPojo.setSymbol_gbpaud(result.getString("GBPAUD"));
				settingPojo.setSymbol_gbpjpy(result.getString("GBPJPY"));
				settingPojo.setSymbol_gbpusd(result.getString("GBPUSD"));
				settingPojo.setSymbol_nzdusd(result.getString("NZDUSD"));
				settingPojo.setSymbol_usdcad(result.getString("USDCAD"));
				settingPojo.setSymbol_usdchf(result.getString("USDCHF"));
				settingPojo.setSymbol_usdjpy(result.getString("USDJPY"));
				settingPojo.setSymbol_xauusd(result.getString("XAUUSD"));
		
		
			}

			String json = JSON.toJSONString(settingPojo);
			System.out.println(json);

		} catch (Exception e) {
			stmt.close();
			conn.close();

		} finally {

			stmt.close();
			conn.close();
		}
		return settingPojo;

	}

	public static String updateTraderSetting(String mt4Account, String symbol, String direction) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		String code = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// System.out.println("連接成功MySQLToJava");
			// 建立讀取資料庫 (test 為資料庫名稱; user 為MySQL使用者名稱; passwrod 為MySQL使用者密碼)
			String datasource = "jdbc:mysql://45.32.49.87:3306/myforex?user=root&password=36f57bc6fd&useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
			// 以下的資料庫操作請參考本blog中: "使用 Java 連結與存取 access 資料庫 (JDBC)"
			conn = DriverManager.getConnection(datasource);
			System.out.println("連接成功MySQL");
			stmt = conn.createStatement();

			String sql = "	UPDATE fo_admsystem SET " + symbol + " = '" + direction + "' WHERE MT4_ACCOUNT =  "
					+ mt4Account;
			System.out.println("更新AMD系統使用DB语法:" + sql);
			stmt.executeUpdate(sql);
		
			
		} catch (Exception e) {
			code = "-1";
			e.printStackTrace();

		} finally {
			
			conn.close();

		}
		code = "0";
		return code;

	}

}
