<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<HTML>
<HEAD><%@ include file="head.txt"%></HEAD>
<BODY bgcolor=yellow>
	<Font size=2><CENTER>
			<BR>文件将被上传到F:\ch10\userImage\中。 <BR>选择要上传的图像照片文件(名字不可以含有非ASCII码字符，比如汉字等)：
			<FORM action="helpUpload" method="post" ENCTYPE="multipart/form-data">
				<INPUT type=FILE name="fileName" size="40"> <BR> <INPUT
					type="submit" name="g" value="提交">
			</FORM>
		</CENTER> </font>
</BODY>
</HTML>