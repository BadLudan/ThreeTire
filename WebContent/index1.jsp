<%@page import="com.airludan.entitis.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>爱好</td>
			<td>邮箱</td>
		</tr>
		<%
			@SuppressWarnings("unchecked")
			ArrayList<Student> stus = (ArrayList<Student>) session.getAttribute("AllStudent");
			for (Student stu : stus) {
		%><tr>
			<td><%=stu.getNo() %></td>
			<td><%=stu.getName() %></td>
			<td><%=stu.getAge() %></td>
			<td><%=stu.getHobby()%></td>
			<td><%=stu.getEmail()%></td>
			<td><a href="DeleteStudentServlet?uno=<% out.print(stu.getNo()); %>">删除</a></td>
			<td><a href="update.jsp?uno=<% out.print(stu.getNo()); %>">更新</a></td>
			</tr>
		<%
			}
		%>
	</table>
	<a href="register.jsp">增加学生</a>
	<a href="search.jsp">查找学生</a>
	<a href="FenyeServlet">分页查看</a>
</body>
</html>