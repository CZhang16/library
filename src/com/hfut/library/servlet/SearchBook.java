package com.hfut.library.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hfut.library.entity.Book;
import com.hfut.library.entity.Custom;
import com.hfut.library.service.BookService;
import com.hfut.library.service.impl.BookServiceImpl;
/**
 * 搜索图书
 * @author ZC
 *
 */
public class SearchBook extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//用户身份验证
		HttpSession session = request.getSession(false);
		if((((Custom)session.getAttribute("custom")).isAdmin())){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}	
		request.setCharacterEncoding("utf-8");
		BookService service = new BookServiceImpl();
		String method = request.getParameter("method");
		String searchText = request.getParameter("searchText");
		List<Book> list = null;
		if("name".equals(method)){
			list = service.fingByName(searchText);
		}else if("author".equals(method)){
			list = service.findByAuthor(searchText);
		}
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/searchBook.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
