package com.hfut.library.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hfut.library.entity.Custom;
import com.hfut.library.exception.HaveCustomException;
import com.hfut.library.service.CustomService;
import com.hfut.library.service.impl.CustomServiceImpl;

public class Register extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		CustomService dao = new CustomServiceImpl();
		Custom custom = new Custom();
		custom.setName(request.getParameter("name"));
		custom.setGender(request.getParameter("gender"));
		custom.setPhone(request.getParameter("phone"));
		custom.setPassword(request.getParameter("password"));
		try {
			dao.addCustom(custom);
		} catch (HaveCustomException e) {
			//将自定义错误信息传到域对象中
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
