<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="mybean.data.ModifyMessage"%>
<jsp:useBean id="modify" type="mybean.data.ModifyMessage"
	scope="request" />
<HTML>
<HEAD><%@ include file="head.txt"%></HEAD>
<BODY bgcolor=yellow>
	<CENTER>
		<jsp:getProperty name="modify" property="backNews" />
		<BR>您修改信息如下： <BR>新广告标题:<jsp:getProperty name="modify"
			property="newAdvertiseTitle" />
		<BR>新电话:<jsp:getProperty name="modify" property="newPhone" />
		<BR>新email:<jsp:getProperty name="modify" property="newEmail" />
		<BR>新广告词:<jsp:getProperty name="modify" property="newMessage" />
	</CENTER>
</BODY>
</HTML>
