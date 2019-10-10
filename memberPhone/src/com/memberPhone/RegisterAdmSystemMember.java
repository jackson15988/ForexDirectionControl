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
 * Servlet implementation class registerAdmSystemMember
 */
@WebServlet("/RegisterAdmSystemMember")
public class RegisterAdmSystemMember extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("開始註冊--註冊區域 ");
	
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		JSONObject json = JSONObject.fromObject(sb.toString());
		
		String phoneNumber = (String) json.get("phonenumber");
		String verificationCode = (String) json.get("verificationCode");
		PrintWriter out = response.getWriter();
		try {
			AdmMemberData admData = GetTraderSettingDAO.getAdmMemberList(phoneNumber);
			if (!admData.getVerification_code().equals(verificationCode)) {
				System.out.println("驗證失敗!!");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				String str = "{\"code\":\"-1\",\"message\":\"verification failed\"}";
				out.println(str);

			} else {
				System.out.println("驗證成功!!");
				request.getSession().setAttribute("isLgoin", "Y");
				request.getSession().setAttribute("Account", phoneNumber);
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				String str = "{\"code\":\"0\",\"message\":\"Successful verification!!\"}";
				out.println(str);
	

			}
		} catch (SQLException e) {
			String str = "{\"code\":\"-1\",\"message\":\"驗證失敗!! : " + e + "\"}";
			out.println(str);
		}

	}

}
