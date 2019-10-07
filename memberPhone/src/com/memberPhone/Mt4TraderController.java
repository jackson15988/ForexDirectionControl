package com.memberPhone;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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

		try {
			
			settingPojo  pojo = new settingPojo();
			pojo = GetTraderSettingDAO.getTraderSettingforMt4(account, symbol.toUpperCase());
			
			
			String jsonreturn = JSON.toJSONString(pojo);
			PrintWriter out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			out.print(jsonreturn);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(account);
		System.out.println(symbol);

	}

}
