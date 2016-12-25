<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="mybean.data.*"%>
<jsp:useBean id="register" type="mybean.data.Register" scope="request" />
<HTML>
<HEAD><%@ include file="head.txt"%></HEAD>
<HTML>
<BODY bgcolor=cyan>
	<CENTER>
		<Font size=4 color=blue> <BR> <jsp:getProperty
				name="register" property="backNews" /> </Font>
		<table>
			<tr>
				<td>注册的会员名称:</td>
				<td><jsp:getProperty name="register" property="logname" /></td>
			</tr>
			<tr>
				<td>注 册 的 广 告 标 题 :</td>
				<td><jsp:getProperty name="register" property="advertiseTitle" /></td>
			</tr>
			<tr>
				<td>注册的电子邮件:</td>
				<td><jsp:getProperty name="register" property="email" /></td>
			</tr>
			<tr>
				<td>注册的联系电话:</td>
				<td><jsp:getProperty name="register" property="phone" /></td>
			</tr>
		</table>
		<table>
			<tr>
				<td>您的广告词：</td>
			</tr>
			<tr>
				<td><TextArea name="message" Rows="6" Cols="30"> 
               <jsp:getProperty name="register" property="message" /> 
           </TextArea></td>
			</tr>
		</table>
	</CENTER>
</BODY>
</HTML>
