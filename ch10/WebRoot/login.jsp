<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<HTML>
<HEAD><%@ include file="head.txt"%></HEAD>
<BODY bgcolor=pink  onLoad="document.forms.login.logname.focus()">
	<CENTER>
		<FORM name="login" action="helpLogin" Method="post">
			<table border=2>
				<tr>
					<th>请您登录</th>
				</tr>
				<tr>
					<td>登录名称:<Input type=text name="logname"/>
					</td>
				</tr>
				<tr>
					<td>输入密码:<Input type=password name="password">
					</td>
				</tr>
				<tr>
					<td><Input type=submit name="g" value="提交">
					</td>
				<tr>
			</table>
		</Form>
	</CENTER>
</BODY>
</HTML>


