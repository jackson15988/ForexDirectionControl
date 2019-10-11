package com.memberPhone;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.memberPhone.Pojo.AdmMemberData;

/**
 * Servlet implementation class CheckAccountIsLegalForConnection
 */
@WebServlet("/CheckAccountIsLegalForConnection")
public class CheckAccountIsLegalForConnection extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mt4Account = request.getParameter("mt4Account");
		String accountBalance = request.getParameter("accountBalance");
		String accountStyle = request.getParameter("accountStyle");
		String phoneNumber = request.getParameter("phoneNumber");
		System.out.println("Mt4TraderController收到的電話號碼:" + phoneNumber);
		System.out.println("收到的帳號為:" + mt4Account);

		LinkedHashMap<String, String> resultMap = new LinkedHashMap<String, String>();
		if (phoneNumber == null || phoneNumber.equals("")) {
			resultMap.put("code", "-1");
			resultMap.put("message", "Phone number cannot be empty");

		} else {

			try {
				AdmMemberData resuData = GetTraderSettingDAO.getAdmMemberList(phoneNumber);
				if (resuData == null) {
					resultMap.put("code", "-1");
					resultMap.put("message", "Can't find the information from the phone");
				} else {
					if (mt4Account.equals(resuData.getMt4Account())) {
						resultMap.put("code", "0");
						resultMap.put("message", "Account and system settings match each other");
					} else {
						if (resuData.getMt4Account() == null || "".equals(resuData.getMt4Account())) {
							resultMap.put("code", "-1");
							resultMap.put("message", "You have not set up a trading account");
						}
						resultMap.put("code", "-1");
						resultMap.put("message", "Account does not match system settings");
					}

				}

			} catch (SQLException e) {
				resultMap.put("code", "-1");
				resultMap.put("message", e.toString());
			}

		}
		String jsonreturn = JSON.toJSONString(resultMap);
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		out.print(jsonreturn);
	}

}
