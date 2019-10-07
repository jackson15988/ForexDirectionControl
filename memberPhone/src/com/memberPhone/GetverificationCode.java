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

import net.sf.json.JSONObject;

/**
 * Servlet implementation class getverificationCode
 */
@WebServlet("/GetverificationCode")
public class GetverificationCode extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		JSONObject json = JSONObject.fromObject(sb.toString());
		
		String phoneNumber = (String) json.get("phonenumber");
		System.out.println("取得電話號碼為:" + phoneNumber);
		int verificationCode = (int) (Math.random() * (9999 - 1000 + 1)) + 1000;
		System.out.println("取得的四位數驗證碼為:" + verificationCode);
		PrintWriter out = response.getWriter();
		try {
			String code = GetTraderSettingDAO.registerforgetVerificationCode(phoneNumber,
					String.valueOf(verificationCode));

			System.out.println("成功與否:" + code);
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			if (code.equals("0")) {
				String str = "{\"code\":\"0\",\"message\":\"更新成功\"}";
				out.println(str);
			} else {
				out.write("[{\"code\":-1,\"message\":錯誤}]");
				String str = "{\"code\":\"-1\",\"message\":\"錯誤\"}";
				out.println(str);
			}
		} catch (ClassNotFoundException e) {
			out.write("[{\"code\":-1,\"message\":"+e+"}]");
			String str = "{\"code\":\"-1\",\"message\":\"錯誤\"}";
			out.println(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
