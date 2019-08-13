package com.airludan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airludan.entitis.Student;
import com.airludan.service.StudentService;

/**
 * Servlet implementation class SearchStudent
 */
@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����POST���յı���
		request.setCharacterEncoding("utf-8");
		// ����out����ı���
		response.setCharacterEncoding("utf-8");
		// ����ҳ�����
		response.setContentType("text/html; charset=UTF-8");
		// �õ�����
		int uno = Integer.parseInt(request.getParameter("uno"));
		// ����out����
		PrintWriter out = response.getWriter();
		Student rs = StudentService.searchStudent(uno);
		if (rs!=null) {
			out.print("���ҳɹ�" + rs.toString());
		} else {
			out.print("û�и�ѧ�ŵ�ѧ��");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
