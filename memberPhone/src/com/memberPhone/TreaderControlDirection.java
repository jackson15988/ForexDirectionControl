package com.memberPhone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class TreaderControlDirection
 */
@WebServlet("/TreaderControlDirection")
public class TreaderControlDirection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		JSONObject json = JSONObject.fromObject(sb.toString());
		PrintWriter out = response.getWriter();
		try {

			System.out.println(json.get("mt4Account").toString());
			System.out.println(json.get("direction").toString());

			String[] strs = json.get("direction").toString().split("_");
			String exStr = GetTraderSettingDAO.updateTraderSetting(json.get("mt4Account").toString(), strs[0], strs[1]);

			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			if (exStr.equals("0")) {
				String str = "{\"code\":\"0\",\"message\":\"更新成功\"}";
				out.println(str);
			} else {
				out.write("[{\"code\":-1,\"message\":錯誤}]");
				String str = "{\"code\":\"-1\",\"message\":\"錯誤\"}";
				out.println(str);
			}

		} catch (Exception e) {
			out.write("[{\"code\":-1,\"message\":錯誤}]");
			String str = "{\"code\":\"-1\",\"message\":\"錯誤\"}";
			out.println(str);

		}

	}

}
