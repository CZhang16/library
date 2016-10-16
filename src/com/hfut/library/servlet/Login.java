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
/**
 * 接收登陆信息
 * @author ZC
 *
 */
public class Login extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomService dao = new CustomServiceImpl();
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);
		//获取用户
		Custom custom = dao.getCustom(name, password);
		
		if(custom==null){
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else if(custom.isAdmin()){
			//管理员
			request.setAttribute("custom", custom);
			session.setAttribute("custom", custom);
			request.getRequestDispatcher("/BookManage").forward(request, response);
		}else{
			//普通用户
			request.setAttribute("custom", custom);
			session.setAttribute("custom", custom);
			request.getRequestDispatcher("/Homepage").forward(request, response);
		}
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
