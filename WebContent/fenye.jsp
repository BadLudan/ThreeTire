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
			int currentPage = (int) request.getAttribute("page");//当前的页面号
			int pageLines = (int) request.getAttribute("pageLines");//获得每行显示的数据
			int pageCount = ((int) request.getAttribute("count") + 4) / pageLines;//算出应该有多少页
			@SuppressWarnings("unchecked")
			ArrayList<Student> stus = (ArrayList<Student>) request.getAttribute("AllStudent");//获得学生的数据
			for (Student stu : stus) {
				//打印出学生的数据
		%><tr>
			<td><%=stu.getNo()%></td>
			<td><%=stu.getName()%></td>
			<td><%=stu.getAge()%></td>
			<td><%=stu.getHobby()%></td>
			<td><%=stu.getEmail()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="FenyeServlet?page=0">首页</a>&nbsp;&nbsp;

	<%
		if (currentPage != 0) {
	%>
	<a href="FenyeServlet?page=<%=request.getAttribute("previous_page")%>">上一页</a>&nbsp;&nbsp;
	<%
		}
		for (int i = 1; i <= pageCount; i++) {
			if (i == currentPage + 1) {
				out.print(i + "&nbsp;&nbsp;&nbsp;");
			} else {
	%>
	<a href="FenyeServlet?page=<%=i - 1%>"><%=i%></a>&nbsp;&nbsp;&nbsp;
	<%
		}
		}
		if (currentPage != pageCount-1) {
	%>
	<a href="FenyeServlet?page=<%=request.getAttribute("next_page")%>">下一页</a>&nbsp;&nbsp;
	<%
		}
	%>
	<a href="FenyeServlet?page=<%=pageCount-1%>">尾页</a>&nbsp;&nbsp;
</body>
</html>