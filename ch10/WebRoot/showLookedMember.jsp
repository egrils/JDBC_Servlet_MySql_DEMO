<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="mybean.data.MemberInform"%>
<HTML>
<head><%@ include file="head.txt"%>
<jsp:useBean id="inform" type="mybean.data.MemberInform" scope="request" /></HEAD>
<BODY bgcolor=pink>
	<Center>
		<table border=2>
			<tr>
				<th>会员名</th>
				<th>广告标题</th>
				<th>电话</th>
				<th>email</th>
				<th>广告词</th>
				<th>广告照片</th>
			</tr>
			<tr>
				<td><jsp:getProperty name="inform" property="logname" /></td>
				<td><jsp:getProperty name="inform" property="advertiseTitle" /></td>
				<td><jsp:getProperty name="inform" property="phone" /></td>
				<td><jsp:getProperty name="inform" property="email" /></td>
				<td>a<jsp:getProperty name="inform" property="message" /></td>
				<td><img src=Images/userImage/<jsp:getProperty name= "inform" property="pic" /> width=50 height=50 />
				</td>
		</table>
	</Center>
</html>
