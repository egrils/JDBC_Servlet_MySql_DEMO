<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<HTML>
<HEAD><%@ include file="head.txt"%></HEAD>
<%@ page import="mybean.data.Register"%>
<jsp:useBean id="register" type="mybean.data.Register" scope="request" />
<HTML>
<BODY bgcolor=pink  onLoad="document.forms.form.newAdvertiseTitle.focus()">
	<CENTER>
		<P>
			<Font color=blue size=4> 以下是您(<jsp:getProperty name="register"
					property="logname" />)曾注册的信息， 您可以修改这些信息。 </Font> <Font size=2>
				<FORM action="helpModifyMess" name=form>
					<table>
						<tr>
							<td>广告标题:</td>
							<td><Input type=text name="newAdvertiseTitle"
								value=<jsp:getProperty name="register" property="advertiseTitle" />>
							</td>
						</tr>
						<tr>
							<td>联系电话:</td>
							<td><Input type=text name="newPhone"
								value=<jsp:getProperty name="register" property="phone" />>
							</td>
						</tr>
						<tr>
							<td>电子邮件:</td>
							<td><Input type=text name="newEmail"
								value=<jsp:getProperty name="register" property="email" />>
							</td>
						</tr>
					</table>
					<table>
						<tr>
							<td>广告词：</td>
						</tr>
						<tr>
							<td><TextArea name="newMessage" Rows="6" Cols="30">
								<jsp:getProperty name="register" property="message" />
								</TextArea>
							</td>
						</tr>
						<tr>
							<td><Input type=submit name="g" value="提交修改">
							</td>
						</tr>
						<tr>
							<td><Input type=reset value="重置">
							</td>
						</tr>
					</table>
					<Font>
	</CENTER>
</BODY>
</HTML>
