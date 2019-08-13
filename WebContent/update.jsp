<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateStudent" method = "Post">
<%
	String id = (String)request.getParameter("uno");

%>
	学号:<input type = "text" name="uno" width="120px " value = "<%=id %>" /><br />

	用户名:<input type = "text" name="uname" width="120px"><br />
	密码:<input type = "text" name="upsw" width="120px"><br />
	年龄:<input type = "text" name="uage" width="120px"><br />
	爱好:<input type = "text" name="uhobby" width="120px"><br />
	邮箱:<input type = "text" name="uemail" width="120px"><br />
	<input type = "submit" />
</form>
</body>
</html>