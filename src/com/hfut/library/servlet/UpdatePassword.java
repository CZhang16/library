package com.hfut.library.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hfut.library.entity.Custom;
import com.hfut.library.service.CustomService;
import com.hfut.library.service.impl.CustomServiceImpl;

public class UpdatePassword extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		CustomService service = new CustomServiceImpl();
		
		Custom custom = (Custom)session.getAttribute("custom");
		String prepassword = request.getParameter("prepassword");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		if(!custom.getPassword().equals(prepassword)){
			request.setAttribute("msg0", "密码错误");
			request.getRequestDispatcher("/updatePassword.jsp").forward(request, response);
			return;
		}
		if(!password1.equals(password2)){
			request.setAttribute("msg1", "两次密码不同");
			request.getRequestDispatcher("/updatePassword.jsp").forward(request, response);
			return;
		}
		service.updatePassword(custom.getId(), password1);
		response.sendRedirect(request.getContextPath()+"/Logout");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
