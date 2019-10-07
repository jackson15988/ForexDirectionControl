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
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class SettingPassword
 */
@WebServlet("/SettingPassword")
public class SettingPassword extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String account = request.getSession().getAttribute("Account") == null ? ""
				: request.getSession().getAttribute("Account").toString();
		String isLogin = request.getSession().getAttribute("isLgoin") == null ? ""
				: request.getSession().getAttribute("isLgoin").toString();

		System.out.println("設定密碼頁面帳號:" + account);
		System.out.println("設定密碼是否登入:" + isLogin);

		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		JSONObject json = JSONObject.fromObject(sb.toString());
		String checkpassword = (String) json.get("checkpassword");
		PrintWriter out = response.getWriter();

		if (isLogin.equals("Y")) {
			try {
				String code = GetTraderSettingDAO.updataPassword(account, checkpassword);
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				if (code.equals("0")) {
					  HttpSession oldSession = request.getSession();
					  oldSession.removeAttribute("account");
					  oldSession.removeAttribute("isLogin");
					  oldSession.invalidate(); // 令目前 Session 失效
					String str = "{\"code\":\"0\",\"message\":\"設定密碼成功\"}";
					out.println(str);
				} else {
					out.write("[{\"code\":-1,\"message\":錯誤}]");
					String str = "{\"code\":\"-1\",\"message\":\"錯誤\"}";
					out.println(str);
				}
			} catch (SQLException e) {
				out.write("[{\"code\":-1,\"message\":錯誤}]");
				String str = "{\"code\":\"-1\",\"message\":\""+e+"\"}";
				out.println(str);
			}
		}

	}

}
