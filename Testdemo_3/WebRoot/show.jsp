<%@ page language="java" import="java.util.*,message.*,javax.servlet.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/show.css" />
          
	<script>
		if(window.XMLHttpRequest) {  
			//IE7, Firefox, Opera支持  
			req = new XMLHttpRequest();  
		}else if(window.ActiveXObject) {  
			//IE5,IE6支持  
			req = new ActiveXObject("Microsoft.XMLHTTP");  
  		} 
  		
		function selectPK(){
		
			var url = "SelectPKServlet?inputID=" + encodeURIComponent(inputID.value);

	   		req.open("POST", url, true);
	   		req.onreadystatechange = callback;  
	     
	   		req.send(null); 
		}
		
		function callback() {  
		    if(req.readyState == 4 && req.status == 200) {
		        document.getElementById("showPublicKey").innerHTML = req.responseText;
		    }  
		}  
		
		
		function submitMessage(){
			 
  			var url = "UpdateMesServlet?friendID=" + encodeURIComponent(friendID.value)+"&message=" + encodeURIComponent(message.value);

	   		req.open("POST", url, true);
	   		req.onreadystatechange = alertMes;
	     
	   		req.send(null); 
		}
		
		function alertMes(){
			if(req.readyState == 4 && req.status == 200) {
				alert("提交成功");
			} 
		};  
		
	</script>

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
    	
    		<input  type="text" name="inputID" onClick="this.value=''"/>
    		<input  type="submit" id="selectPublicKey" value="获取公钥" onclick="selectPK()"/>
    		<div>
	    		公钥信息：<span id="showPublicKey"></span>
	    	</div>
    	</div>
    	<div class="leaveMessage">
	    	
	    	<input  type="text" name="friendID" value="请输入对方ID" onClick="this.value=''"/>
	    	<input type="text" name="message" value="请输入你想说的话" onClick="this.value=''"/>
	    	<input type="submit" value="留言" onclick="submitMessage()"/>
    	</div>

    </div>
  </body>
</html>
