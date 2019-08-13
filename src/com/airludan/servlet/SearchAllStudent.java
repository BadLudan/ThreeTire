package com.airludan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airludan.entitis.Student;
import com.airludan.service.StudentService;

/**
 * Servlet implementation class SeatchAllStudent
 */
@WebServlet("/SearchAllStudent")
public class SearchAllStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����POST���յı���
				request.setCharacterEncoding("utf-8");
				// ����out����ı���
				response.setCharacterEncoding("utf-8");
				// ����ҳ�����
				response.setContentType("text/html; charset=UTF-8");
				//����out����
				PrintWriter out = response.getWriter();
				ArrayList<Student> rs = StudentService.searchAllStudent();
				HttpSession session = request.getSession();
				session.setAttribute("AllStudent", rs);
				/*if(rs.size()!=0) {
					Iterator<Student> it = rs.iterator();
					while(it.hasNext()) {
						out.print(it.next().toString() + "<hr />");
					}
				}else {
					out.print("ɾ��ʧ��");
				}*/
				request.getRequestDispatcher("index1.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
