<%@ page language="java" import="java.util.*,com.hfut.library.service.*,com.hfut.library.service.impl.*,com.hfut.library.entity.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>我的图书馆</title>
    <style type="text/css">
    	table td{
    		text-align: center;
    	}
    </style>
	

  </head>
  
  <body>
<div align="center">
<h1>我的图书馆</h1>
<h3>借阅信息</h3>
<table width="600"  border="1">
  <tr>
  	<th>编号</th>
    <th>正在借阅</th>
    <th>借阅日期</th>
    <th>操作</th>
  </tr>
  <c:forEach items="${list }" var="bi" varStatus="status">
  <tr>
  	<td>${status.count }</td>
    <td><%
    BookService service = new BookServiceImpl();
    String ISBN = ((BorrowInfo)pageContext.getAttribute("bi")).getISBN();
    String bookName = service.findByISBN(ISBN).getName();
    
     %><%=bookName %></td>
    <td>${bi.date }</td>
    <td><a href="${pageContext.request.contextPath }/Return?no=${bi.no }">还书</a></td>
  </tr>
  </c:forEach>
  <tr>
  	<td colspan="4"><a href="${pageContext.request.contextPath }/BookList">借书</a></td>
  </tr>
</table>
</div>
<p align="right">${custom.name },<a href="${pageContext.request.contextPath }/Logout">注销</a>
<a href="${pageContext.request.contextPath }/updatePassword.jsp">修改密码</a>
    </p>
  </body>
</html>
