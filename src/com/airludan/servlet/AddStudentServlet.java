package com.airludan.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airludan.entitis.*;
import com.airludan.service.*;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1298371283L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//����out����ı��� 
		response.setCharacterEncoding("utf-8");
		//����ҳ�����
		response.setContentType("text/html; charset=UTF-8");
		//�±�һ��������ȡ����д�ĸ�����Ϣ��
		String uname = request.getParameter("uname");//����
		String upsw = request.getParameter("upsw");//����
		int uage = Integer.parseInt(request.getParameter("uage"));//����
		int uno = Integer.parseInt(request.getParameter("uno"));//ѧ��
		String uhobby = request.getParameter("uhobby");//����
		String uemail = request.getParameter("uemail");//����
		//�½�һ��student���� �����ݷ�װ
		Student stu = new Student(uno, uname, upsw, uage, uhobby, uemail);
		//����session����
		HttpSession session = request.getSession();
		//����һ��Out����
		//PrintWriter out = response.getWriter();
		//����application����
		//ServletContext application = request.getServletContext();
		//����bll���addStudent��student���󴫹�ȥ
		if (StudentService.addStudent(stu)) {
			response.sendRedirect("success.jsp");
		} else {
			session.setAttribute("errorInfo", "�Ѵ�����ͬ��ѧ��");
			response.sendRedirect("error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
