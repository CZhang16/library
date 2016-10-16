<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>管理图书</title>

  </head>
  
  <body>
  <div align="center">
  	<h1>管理图书</h1>
    
    <br/><br/>
    <table border="2px">
    <tr><th>编号</th><th>书名</th><th>作者</th><th>出版社</th><th>操作</th></tr>
    <c:forEach items="${list }" var="book" varStatus="status">
    <tr><th>${status.count }</th><th>${book.name }</th><th>${book.author }</th><th>${book.publisher }</th>
    <th><a href="${pageContext.request.contextPath }/PreUpdateBook?ISBN=${book.ISBN }">修改</a>
    <a href="${pageContext.request.contextPath }/RemoveBook?ISBN=${book.ISBN }">删除</a></th></tr>
    </c:forEach>
    
    <tr><th colspan="5">
    <a href="${pageContext.request.contextPath }/addBook.jsp">添加</a></th></tr>
    </table>
    <p align="right">${custom.name },<a href="${pageContext.request.contextPath }/Logout">注销</a><a href="${pageContext.request.contextPath }/updatePassword.jsp">修改密码</a></p>
    
 </div>
  </body>
</html>
