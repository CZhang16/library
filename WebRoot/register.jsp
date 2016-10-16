<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<style type="text/css">
	table th{
		text-align: center;
	}
	</style>
  </head>
  
  <body>
    <center><h3>用户注册</h3></center>
  <form action="${pageContext.request.contextPath }/Register" method="post" >
   <table align="center" border="3px">
   		<tr><th>用户名</th><td><input type="text" name="name"/><font color="red">${msg }</font></td></tr>
   		<tr><th>性别</th><td><input type="radio" name="gender" value="男" checked="checked"/>男&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="gender" value="女"/>女</td></tr>
   		<tr><th>电话</th><td><input type="text" name="phone"/></td></tr>
   		<tr><th>密码</th><td><input type="password" name="password"/></td></tr>
   		<tr><th colspan="2"><input type="submit" value="提交"/><input type="reset" value="清空"/></th></tr>
   		
   
   </table>
  </form>
  </body>
</html>
