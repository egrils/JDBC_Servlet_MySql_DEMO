<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<HTML>
<HEAD><%@ include file="head.txt"%></HEAD>
<BODY bgcolor=cyan  onLoad="document.forms.form.logname.focus()">
	<CENTER>
		<FORM action="helpRegister" name=form>
			<table>
				输入您的信息，会员名字必须由字母和数字组成，带*号项必须填写。
				<tr>
					<td>会员名称:</td>
					<td><Input type=text name="logname">*</td>
				</tr>
				<tr>
					<td>设置密码:</td>
					<td><Input type=password name="password">*</td>
				</tr>
				<tr>
					<td>广告标题:</td>
					<td><Input type=text name="advertiseTitle">*</td>
				</tr>

				<tr>
					<td>电子邮件:</td>
					<td><Input type=text name="email">
					</td>
				</tr>
				<tr>
					<td>联系电话:</td>
					<td><Input type=text name="phone">
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td>输入您的广告词：</td>
				</tr>
				<tr>
					<td><TextArea name="message" Rows="6" Cols="30"></TextArea>
					</td>
				</tr>
				<tr>
					<td><Input type=submit name="g" value="提交">
					</td>
				</tr>
			</table>
		</Form>
	</CENTER>
</Body>
</HTML>
