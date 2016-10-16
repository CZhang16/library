<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>搜索图书</title>

  </head>
  
  <body>
  <div align="center">
  	<h1>搜索图书</h1>
    <form action="${pageContext.request.contextPath }/SearchBook" method="post">
    <table>
    <tr>
    	<th><select name="method"><option value="name">书名</option><option value="author">作者</option></select></th>
    	<th><input type="text" name="searchText" /></th>
    	<th><input type="submit" value="搜索"/></th>
    </tr>
    </table>
    </form>
    <br/><br/>
    <table border="2px">
    <tr><th>编号</th><th>书名</th><th>作者</th><th>出版社</th><th>操作</th></tr>
    <c:forEach items="${list }" var="book" varStatus="status">
    <tr><th>${status.count }</th><th>${book.name }</th><th>${book.author }</th><th>${book.publisher }</th><th><a href="${pageContext.request.contextPath }/BorrowBook?ISBN=${book.ISBN }">借书</a></th></tr>
    </c:forEach>
    </table>
    
 </div>
 <p align="right">${custom.name },<a href="${pageContext.request.contextPath }/Logout">注销</a></p>
  </body>
</html>
