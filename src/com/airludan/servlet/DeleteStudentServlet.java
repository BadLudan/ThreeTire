package com.airludan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.airludan.service.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����POST���յı���
		request.setCharacterEncoding("utf-8");
		// ����out����ı���
		response.setCharacterEncoding("utf-8");
		// ����ҳ�����
		response.setContentType("text/html; charset=UTF-8");
		//�õ�����
		int uno = Integer.parseInt(request.getParameter("uno"));
		//����out����
		PrintWriter out = response.getWriter();
		boolean rs = StudentService.deleteStudent(uno);
		if(rs) {
			out.print("ɾ���ɹ�");
		}else {
			out.print("ɾ��ʧ��");
		}
		response.sendRedirect("SearchAllStudent");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
