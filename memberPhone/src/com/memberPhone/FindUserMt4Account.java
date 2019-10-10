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

import com.alibaba.fastjson.JSON;
import com.memberPhone.Pojo.AdmMemberData;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class FindUserMt4Account
 */
@WebServlet("/FindUserMt4Account")
public class FindUserMt4Account extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		JSONObject json = JSONObject.fromObject(sb.toString());
		String phoneNumber = (String) json.get("phoneNumber");
		System.out.println("取得電話號碼為:" + phoneNumber);
		try {
			AdmMemberData memeberData = GetTraderSettingDAO.filterMemberGetAdmMemberList(phoneNumber);
			memeberData.setPassword("");
			String jsonreturn = JSON.toJSONString(memeberData);
			PrintWriter out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			out.print(jsonreturn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
