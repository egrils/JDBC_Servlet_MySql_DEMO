<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="mybean.data.*"%>
<jsp:useBean id="upFile" class="mybean.data.UploadFile" scope="request" />

<HTML>
<HEAD><%@ include file="head.txt"%></HEAD>
<HTML>
<BODY bgcolor=yellow>
	<CENTER>
		<Font size=2 color=blue> <BR> 
		<jsp:getProperty name="upFile" property="backNews" /> 
		</Font> 
		<BR>
		<Font size=2>上传的文件名字：<jsp:getProperty name="upFile"
				property="fileName" /> 保存后的文件名字：
				<jsp:getProperty name="upFile" property="savedFileName" /> <BR> 
				<img src='/userImage/<jsp:getProperty property="savedFileName" name="upFile"/>' width=500 height=500/>
				<br />图像效果
		</FONT>
	</CENTER>
</BODY>
</HTML>
