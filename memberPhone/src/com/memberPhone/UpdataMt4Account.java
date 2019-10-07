package com.memberPhone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.memberPhone.Pojo.AdmMemberData;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UpdataMt4Account
 */
@WebServlet("/UpdataMt4Account")
public class UpdataMt4Account extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdmMemberData memberData = new AdmMemberData();
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		JSONObject json = JSONObject.fromObject(sb.toString());

		String phoneNumber = (String) json.get("phoneNumber");
		String accountStyle = (String) json.get("accountStyle");
		String mt4account = (String) json.get("mt4account");
		PrintWriter out = response.getWriter();
		try {
			memberData = GetTraderSettingDAO.filterMemberGetAdmMemberList(phoneNumber);
			String mtA = memberData.getMt4Account();
			if (mtA.equals("DefaultAccount")) {
				String code = GetTraderSettingDAO.updatamt4Account(phoneNumber, mt4account, accountStyle);
				code = GetTraderSettingDAO.inserNewAdmSystemAccount(phoneNumber, mt4account, "3");
			} else {
				// 單純的updata 資料 外加再加上 更新list列表
				String code = GetTraderSettingDAO.updatamt4Account(phoneNumber, mt4account, accountStyle);
				code = GetTraderSettingDAO.updataAdmSystemAccount(mtA, mt4account);
			}
			
			request.getSession().setAttribute("mt4Account", mt4account);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
