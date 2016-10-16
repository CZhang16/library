<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改密码</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<style type="text/css">
	table th{
		text-align: center;
	}
	</style>
  </head>
  
  <body>
  <center><h3>修改密码</h3></center>
  <form action="${pageContext.request.contextPath }/UpdatePassword" method="post" >
   <table align="center" border="3px">
   		<tr><th>原密码</th><td><input type="password" name="prepassword"/><font color="red">${msg0 }</font></td></tr>
   		<tr><th>新密码</th><td><input type="password" name="password1"/></td></tr>
   		<tr><th>再次输入新密码</th><td><input type="password" name="password2"/><font color="red">${msg1 }</font></td></tr>
   		<tr><th colspan="2"><input type="submit" value="提交"/><input type="reset" value="清空"/></th></tr>
   		
   
   </table>
  </form>
  <p align="right">${custom.name },<a href="${pageContext.request.contextPath }/Logout">注销</a></p>
  </body>
</html>