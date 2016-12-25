<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<HTML>
<HEAD><%@ include file="head.txt"%></HEAD>
<BODY bgcolor=cyan>
	<center>
		<Font size=2>
			<center>
				<FORM action="helpShowMember" method="post" name="form">
					分页显示全体会员 <INPUT type="hidden" value="1" name="showPage" size=5>
					<INPUT type="submit" value="显示" name="submit">
				</Form>
				<FORM action="helpShowMember" method="get" name="form">
					输入要查找的会员名： <INPUT type="text" name="logname" size=5> <INPUT
						type="submit" value="显示" name="submit">
				</FORM>
			</center>
</BODY>
</HTML>
