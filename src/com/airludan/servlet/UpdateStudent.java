package com.airludan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airludan.entitis.Student;
import com.airludan.service.StudentService;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//设置out输出的编码 
		response.setCharacterEncoding("utf-8");
		//设置页面编码
		response.setContentType("text/html; charset=UTF-8");
		//下边一串是用来取表单填写的个人信息的
		String uname = request.getParameter("uname");//姓名
		String upsw = request.getParameter("upsw");//密码
		int uage = Integer.parseInt(request.getParameter("uage"));//年龄
		int uno = Integer.parseInt(request.getParameter("uno"));//学号
		String uhobby = request.getParameter("uhobby");//爱好
		String uemail = request.getParameter("uemail");//邮箱
		//新建一个student对象 把数据封装
		Student stu = new Student(uno, uname, upsw, uage, uhobby, uemail);
		//生成session对象
		HttpSession session = request.getSession();
		//生成一个Out对象
		//PrintWriter out = response.getWriter();
		//生成application对象
		//ServletContext application = request.getServletContext();
		//调用bll层的addStudent把student对象传过去
		if (StudentService.updateStudent(uno, stu)) {
			response.sendRedirect("SearchAllStudent");
		} else {
			session.setAttribute("errorInfo", "查找错误，里边没有这个学生");
			response.sendRedirect("error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
