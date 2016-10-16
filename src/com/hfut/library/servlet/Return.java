package com.hfut.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hfut.library.entity.Custom;
import com.hfut.library.service.BorrowInfoService;
import com.hfut.library.service.impl.BorrowInfoServiceImpl;
/**
 * 还书操作
 * @author ZC
 *
 */
public class Return extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//用户身份验证
		HttpSession session = request.getSession(false);
		if((((Custom)session.getAttribute("custom")).isAdmin())){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}	
		BorrowInfoService service = new BorrowInfoServiceImpl();
		String no = request.getParameter("no");
		service.deleteBorrowInfo(no);
		response.sendRedirect(request.getContextPath()+"/Homepage");
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
