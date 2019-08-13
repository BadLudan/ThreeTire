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
		// 设置POST接收的编码
				request.setCharacterEncoding("utf-8");
				// 设置out输出的编码
				response.setCharacterEncoding("utf-8");
				// 设置页面编码
				response.setContentType("text/html; charset=UTF-8");
				//生成out对象
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
					out.print("删除失败");
				}*/
				request.getRequestDispatcher("index1.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
