package com.hfut.library.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hfut.library.entity.Custom;
import com.hfut.library.service.BorrowInfoService;
import com.hfut.library.service.impl.BorrowInfoServiceImpl;
/**
 * ½èÊé²Ù×÷
 * @author ZC
 *
 */
public class BorrowBook extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		
		BorrowInfoService service = new BorrowInfoServiceImpl();
		
		Custom custom = (Custom) session.getAttribute("custom");
		String ISBN = request.getParameter("ISBN");
		
		service.createBorrowInfo(custom.getId(), ISBN);
		
		response.sendRedirect(request.getContextPath()+"/Homepage");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
