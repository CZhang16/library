<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登陆图书馆</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <center><h1>登陆图书馆</h1></center>
	<form action="${pageContext.request.contextPath }/Login" method="post">
	<table align="center">
	<tr>
	<th>用户名</th><td><input type="text" name="name" /></td>
	</tr>
	<tr>
	<th>密码</th><td><input type="password" name="password" /></td>
	</tr>
	<tr><th colspan="2"><font color="red">${msg }</font></th></tr>
	<tr><th colspan="2"><input type="submit" value="登陆"  /><a href="${pageContext.request.contextPath }/register.jsp">注册</a></th></tr>
	</table>
	</form>
  </body>
</html>
