<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>添加图书</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<style type="text/css">
	table th{
		text-align: center;
	}
	</style>
  </head>
  
  <body>
  <center><h3>添加图书</h3></center>
  <form action="${pageContext.request.contextPath }/AddBook" method="post" >
   <table align="center" border="3px">
   		<tr><th>书号</th><td><input type="text" name="ISBN"/><font color="red">${msg }</font></td></tr>
   		<tr><th>书名</th><td><input type="text" name="name"/></td></tr>
   		<tr><th>作者</th><td><input type="text" name="author"/></td></tr>
   		<tr><th>出版社</th><td><input type="text" name="publisher"/></td></tr>
   		<tr><th colspan="2"><input type="submit" value="提交"/><input type="reset" value="清空"/></th></tr>
   		
   
   </table>
  </form>
  <p align="right">${custom.name },<a href="${pageContext.request.contextPath }/Logout">注销</a></p>
  </body>
</html>