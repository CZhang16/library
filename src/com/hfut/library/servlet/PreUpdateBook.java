package com.hfut.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hfut.library.entity.Book;
import com.hfut.library.entity.Custom;
import com.hfut.library.service.BookService;
import com.hfut.library.service.impl.BookServiceImpl;

public class PreUpdateBook extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//管理员身份验证
		HttpSession session = request.getSession(false);
		if(!(((Custom)session.getAttribute("custom")).isAdmin())){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
				
		BookService service = new BookServiceImpl();
		Book book = service.findByISBN(request.getParameter("ISBN"));
		request.setAttribute("book", book);
		request.getRequestDispatcher("/updateBook.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}	
}
