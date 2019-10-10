package com.memberPhone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alibaba.fastjson.JSON;
import com.memberPhone.Pojo.AdmMemberData;
import com.memberPhone.Pojo.settingPojo;
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

	public static settingPojo getTraderSettingforMt4(String mt4Account, String symobl) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		settingPojo pojo = new settingPojo();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// System.out.println("連接成功MySQLToJava");
			// 建立讀取資料庫 (test 為資料庫名稱; user 為MySQL使用者名稱; passwrod 為MySQL使用者密碼)
			String datasource = "jdbc:mysql://45.32.49.87:3306/myforex?user=root&password=36f57bc6fd&useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
			// 以下的資料庫操作請參考本blog中: "使用 Java 連結與存取 access 資料庫 (JDBC)"
			conn = DriverManager.getConnection(datasource);
			System.out.println("連接成功MySQL");
			stmt = conn.createStatement();
			String sql = "SELECT CUSTOMER_ID , MT4_BROKERS , " + symobl + "  FROM fo_admsystem  WHERE MT4_ACCOUNT='"
					+ mt4Account + "';";

			System.out.println("MT4查詢開單方向使用SQL:" + sql);
			ResultSet result = stmt.executeQuery(sql);
			int rowCount = result.getRow();

			if (rowCount == 0) {
				System.out.println("查詢不到任何資訊:");
			}
			if (result.next()) {
				pojo.setOrderDirectionality(result.getString(symobl));
				pojo.setSymbol(symobl);
			}

		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			conn.close();

		}

		return pojo;
	}

	public static String registerforgetVerificationCode(String phoneNumber, String verificationCode)
			throws ClassNotFoundException, SQLException {

		Connection conn = null;
		Statement stmt = null;
		String successCode = "";
		String sql = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// System.out.println("連接成功MySQLToJava");
			// 建立讀取資料庫 (test 為資料庫名稱; user 為MySQL使用者名稱; passwrod 為MySQL使用者密碼)
			String datasource = "jdbc:mysql://45.32.49.87:3306/myforex?user=root&password=36f57bc6fd&useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
			// 以下的資料庫操作請參考本blog中: "使用 Java 連結與存取 access 資料庫 (JDBC)"
			conn = DriverManager.getConnection(datasource);
			System.out.println("連接成功MySQL");
			stmt = conn.createStatement();

			sql = "SELECT * FROM fo_admmemberlist  WHERE PHONE_NUMBER='" + phoneNumber + "';";
			ResultSet result = stmt.executeQuery(sql);

			if (!result.first()) {
				System.out.println("查詢不到任何資訊:");
				sql = "INSERT INTO `fo_admmemberlist` (`PHONE_NUMBER`, `VERIFICATION_CODE`  , `MT4_ACCOUNT` ,`PASSWORD`) VALUES ('"
						+ phoneNumber + "', '" + verificationCode + "','DefaultAccount','DefaultPassword');";
			} else {
				sql = "	UPDATE fo_admmemberlist SET VERIFICATION_CODE  = '" + verificationCode
						+ "' WHERE PHONE_NUMBER =  " + phoneNumber;
			}
			System.out.println("使用DB语法:" + sql);
			stmt.executeUpdate(sql);
			successCode = "0";

		} catch (SQLException e) {
			e.printStackTrace();
			successCode = "-1";
			conn.rollback();
			stmt.close();
			conn.close();
		}
		return successCode;

	}

	/**
	 * @author admin 取得 ADM 會員的資訊
	 * @param phomeNumber
	 * @return
	 * @throws SQLException
	 */
	public static AdmMemberData getAdmMemberList(String phomeNumber) throws SQLException {

		Connection conn = null;
		Statement stmt = null;

		// 連接MySQL
		AdmMemberData admmember = new AdmMemberData();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// System.out.println("連接成功MySQLToJava");
			// 建立讀取資料庫 (test 為資料庫名稱; user 為MySQL使用者名稱; passwrod 為MySQL使用者密碼)
			String datasource = "jdbc:mysql://45.32.49.87:3306/myforex?user=root&password=36f57bc6fd&useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
			// 以下的資料庫操作請參考本blog中: "使用 Java 連結與存取 access 資料庫 (JDBC)"
			conn = DriverManager.getConnection(datasource);
			System.out.println("連接成功MySQL");
			stmt = conn.createStatement();
			String sql = "SELECT * FROM fo_admmemberlist  WHERE PHONE_NUMBER='" + phomeNumber + "';";
			ResultSet result = stmt.executeQuery(sql);
			int rowCount = result.getRow();
			if (rowCount == 0) {
				System.out.println("查詢不到任何資訊:");
			}
			if (result.next()) {
				admmember.setVerification_code(result.getString("VERIFICATION_CODE"));
				admmember.setPassword(result.getString("VERIFICATION_CODE"));
			}
			String json = JSON.toJSONString(admmember);
			System.out.println(json);

		} catch (Exception e) {
			stmt.close();
			conn.close();
		} finally {
			stmt.close();
			conn.close();
		}
		return admmember;

	}

	/**
	 * @author admin 讓登入使用的
	 * @param phomeNumber
	 * @return
	 * @throws SQLException
	 */
	public static AdmMemberData filterMemberGetAdmMemberList(String phomeNumber) throws SQLException {
		Connection conn = null;
		Statement stmt = null;

		// 連接MySQL
		AdmMemberData admmember = new AdmMemberData();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// System.out.println("連接成功MySQLToJava");
			// 建立讀取資料庫 (test 為資料庫名稱; user 為MySQL使用者名稱; passwrod 為MySQL使用者密碼)
			String datasource = "jdbc:mysql://45.32.49.87:3306/myforex?user=root&password=36f57bc6fd&useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
			// 以下的資料庫操作請參考本blog中: "使用 Java 連結與存取 access 資料庫 (JDBC)"
			conn = DriverManager.getConnection(datasource);
			System.out.println("連接成功MySQL");
			stmt = conn.createStatement();
			String sql = "SELECT * FROM fo_admmemberlist  WHERE PHONE_NUMBER='" + phomeNumber
					+ "' AND VERIFICATION_STATUS = 1  AND  MEMBER_DATE >= CURDATE() ;";
			ResultSet result = stmt.executeQuery(sql);

			if (result.next()) {
				admmember.setVerification_code(result.getString("VERIFICATION_CODE"));
				admmember.setPassword(result.getString("PASSWORD"));
				admmember.setPhoneNumber(result.getString("PHONE_NUMBER"));
				admmember.setMt4Account(result.getString("MT4_ACCOUNT"));
				admmember.setMt4AccountStyle(result.getString("ACCOUNT_STYLE"));
			}
			String json = JSON.toJSONString(admmember);
			System.out.println(json);

		} catch (Exception e) {
			stmt.close();
			conn.close();
		} finally {
			stmt.close();
			conn.close();
		}
		return admmember;

	}

	public static String updataPassword(String phoneNumber, String password) throws SQLException {
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

			String sql = "	UPDATE fo_admmemberlist SET PASSWORD = '" + password + "' WHERE PHONE_NUMBER =  "
					+ phoneNumber;
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

	public static String updatamt4Account(String phoneNumber, String mt4Account, String acountStyle)
			throws SQLException {
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

			String sql = "	UPDATE fo_admmemberlist SET MT4_ACCOUNT = '" + mt4Account + "', ACCOUNT_STYLE = "+acountStyle+" WHERE PHONE_NUMBER =  "
					+ phoneNumber;
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
	
	
	
	public static String inserNewAdmSystemAccount(String phoneNumber, String mt4Account, String mt4Brokers)
			throws SQLException {
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
			String sql = "	INSERT INTO fo_admsystem (CUSTOMER_ID, MT4_ACCOUNT, MT4_BROKERS , PHONE_NUMBER) VALUES ('"+157515+"', '"+mt4Account+"', '"+mt4Brokers+"', '"+phoneNumber+"')";
	
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
	
	
	public static String updataAdmSystemAccount( String mt4Account , String newAccount , String phoneNumber)
			throws SQLException {
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
			String sql = "	UPDATE fo_admsystem SET MT4_ACCOUNT = '" + newAccount + "' WHERE PHONE_NUMBER =  "
					+ phoneNumber;
	
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
