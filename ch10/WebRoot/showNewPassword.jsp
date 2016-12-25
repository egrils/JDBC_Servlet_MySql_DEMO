<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="mybean.data.Password"%>
<jsp:useBean id="password" type="mybean.data.Password" scope="request" />
<HTML>
<HEAD><%@ include file="head.txt"%></HEAD>
<BODY bgcolor=yellow>
	<CENTER>
		<jsp:getProperty name="password" property="backNews" />
		<BR>您的新密码：<jsp:getProperty name="password" property="newPassword" />
		<BR>您的旧密码：<jsp:getProperty name="password" property="oldPassword" />
	</CENTER>
</BODY>
</HTML>
