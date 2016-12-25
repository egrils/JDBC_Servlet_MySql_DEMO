<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/show.css" />
	

  </head>
  
  <body onLoad="document.forms.register.userName.focus()">
  	<div class="header">
  	<form action="ExitServlet">
  		<input type="submit" value="退出"/>
  	</form>
	</div>
   	<form name="register" action="AddInfoServlet" method="post">
   		
   		用户名：<input type="text" name="userName" onblur="this.value=this.value?this.value:'请输入八位数字'"/> 
   		<br />
   		密     码：<input type="password" name="password" onblur="this.value=this.value?this.value:'请输入'" />
   		<br />
   		公     钥：<input type="text" name="publickey" onblur="this.value=this.value?this.value:'请输入'" />
   		<br />
   		摘要算法：<input type="radio" name="dda" value="MD5"/>MD5<input type="radio" name="dda" value="SHA"/>SHA
   		<br />
   		非对称加密算法：<input type="radio" name="aca" value="RSA"/>RSA
   		<br />
   		<input type="submit" value="注册" />
   		
   	</form>
  </body>
</html>
