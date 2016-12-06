<%@ page language="java" import="java.util.*,message.*,javax.servlet.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
  	<%
  	String ID = (String)session.getAttribute("ID");
	String publicKey = (String)session.getAttribute("publicKey");
	String message = showMessage.getMessage(ID);
  	 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/show.css" />
	


  </head>
  
  <body>
  	<div class="header">
  	<form action="ExitServlet">
  		欢迎你：<% out.print(ID); %> ，<input type="submit" value="退出"/>
  	</form>
	</div>
  	<div class="showMessage">
  		我的留言：<% out.print(isNull.judgeMessage(message)); %>
  	</div>
    <div>
    	<div class="getPublicKey">
    	获取公钥功能:
    	<form action="SelectPKServlet" method="get">
    		<input  type="text" name="inputID" value="请输入对方ID" onClick="this.value=''"/>
    		<input  type="submit"  value="获取公钥" onClick="this.value=''"/>
    	</form>
    	</div>
    	<div class="leaveMessage">
	    	<div>
	    		公钥信息：<% out.print(isNull.judgeMessage(publicKey));%>
	    	</div>
	    	<form action="UpdateMesServlet" method="post">
	    		<input  type="text" name="friendID" value="请输入对方ID" onClick="this.value=''"/>
	    		<input type="text" name="message" value="请输入你想说的话" onClick="this.value=''"/>
	    		<input type="submit" value="留言" />
	    	</form>
    	</div>

    </div>
  </body>
</html>
