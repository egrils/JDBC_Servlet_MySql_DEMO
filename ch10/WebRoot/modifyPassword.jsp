<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<HTML>
<HEAD><%@ include file="head.txt"%></HEAD>
<BODY bgcolor=pink onLoad="document.forms.modifyPas.oldPassword.focus()">
	<Font size=2><CENTER>
			<BR>输入您的密码：
			<FORM name="modifyPas" action="helpModifyPassword" Method="post">
				<BR>当前密码:<Input type=text name="oldPassword"> <BR>新密码:
				<Input type=password name="newPassword"> <BR>
				<Input type=submit name="g" value="提交">
			</Form>
		</CENTER>
</BODY>
</HTML>
