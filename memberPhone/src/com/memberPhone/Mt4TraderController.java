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
import com.memberPhone.Pojo.settingPojo;

/**
 * Servlet implementation class Mt4TraderController
 */
@WebServlet("/Mt4TraderController")
public class Mt4TraderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String account = request.getParameter("mt4Account");
		String symbol = request.getParameter("symbol");
		String phoneNumber = request.getParameter("phoneNumber");

		System.out.println("Mt4TraderController收到的電話號碼:" + phoneNumber);
		System.out.println("收到的帳號為:" + account);
		LinkedHashMap<String, String> resultMap = new LinkedHashMap<String, String>();

		try {
			if (account == null || account == "") {
				resultMap.put("code", "-1");
				resultMap.put("message", "交易帳號不得為空值");

				String jsonreturn = JSON.toJSONString(resultMap);
				PrintWriter out = response.getWriter();
				response.setCharacterEncoding("utf-8");
				response.setContentType("application/json; charset=UTF-8");
				out.print(jsonreturn);

			} else if (symbol == null || symbol == "") {
				resultMap.put("code", "-1");
				resultMap.put("message", "Symbol cannot be empty");
				String jsonreturn = JSON.toJSONString(resultMap);
				PrintWriter out = response.getWriter();
				response.setCharacterEncoding("utf-8");
				response.setContentType("application/json; charset=UTF-8");
				out.print(jsonreturn);

			} else {
				settingPojo pojo = new settingPojo();
				pojo = GetTraderSettingDAO.getTraderSettingforMt4(account, symbol.toUpperCase());
				String jsonreturn = JSON.toJSONString(pojo);
				PrintWriter out = response.getWriter();
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				out.print(jsonreturn);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(account);
		System.out.println(symbol);

	}

}
