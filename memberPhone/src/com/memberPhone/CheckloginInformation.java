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
 * Servlet implementation class CheckloginInformation
 */
@WebServlet("/CheckloginInformation")
public class CheckloginInformation extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			JSONObject json = JSONObject.fromObject(sb.toString());
			String phoneNumber = (String) json.get("phoneNumber");
			String password = (String) json.get("password");
			AdmMemberData memeberData = GetTraderSettingDAO.filterMemberGetAdmMemberList(phoneNumber);
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			if (memeberData.getPhoneNumber() != null) {

				if (password.equals(memeberData.getPassword())) {
					request.getSession().setAttribute("isLgoin", "Y");
					request.getSession().setAttribute("Account", phoneNumber);
					request.getSession().setAttribute("permissionLogin", "Y");
					request.getSession().setAttribute("mt4Account", memeberData.getMt4Account());
					System.out.println("代表有資料且密碼符合");
					String str = "{\"code\":\"0\",\"message\":\"登入成功\"}";
					out.println(str);
				} else {
					System.out.println("密碼不符合");
					String str = "{\"code\":\"-1\",\"message\":\"密碼不符合\"}";
					out.println(str);
				}
			} else {
				String str = "{\"code\":\"-1\",\"message\":\"查無該帳號，或還未開通!!\"}";
				out.println(str);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
