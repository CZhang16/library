<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改图书信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<style type="text/css">
	table th{
		text-align: center;
	}
	</style>
  </head>
  
  <body>
  <center><h3>修改图书信息</h3></center>
  <form action="${pageContext.request.contextPath }/UpdateBook" method="post" >
  		<input type="hidden" name="ISBN" value="${book.ISBN }"/>
   <table align="center" border="3px">
   		<tr><th>书名</th><td><input type="text" name="name" value="${book.name }"/></td></tr>
   		<tr><th>作者</th><td><input type="text" name="author" value="${book.author }"/></td></tr>
   		<tr><th>出版社</th><td><input type="text" name="publisher" value="${book.publisher }"/></td></tr>
   		<tr><th colspan="2"><input type="submit" value="提交"/><input type="reset" value="清空"/></th></tr>
   		
   
   </table>
  </form>
  <p align="right">${custom.name },<a href="${pageContext.request.contextPath }/Logout">注销</a></p>
  </body>
</html>
