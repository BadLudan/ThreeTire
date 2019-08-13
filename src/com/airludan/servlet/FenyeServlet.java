package com.airludan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.airludan.entitis.Student;
import com.airludan.service.StudentService;

/**
 * Servlet implementation class FenyeServlet
 */
@WebServlet("/FenyeServlet")
public class FenyeServlet extends HttpServlet {
	private static final long serialVersionUID = 247123826L;
	private static final int pageLines = 5;
	private static int page;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 设置out输出的编码
		response.setCharacterEncoding("utf-8");
		// 设置页面编码
		response.setContentType("text/html; charset=UTF-8");
		String strPage = request.getParameter("page");
		int count = StudentService.searchAllStudentCount();

		if (strPage == null) {
			page = 0;
		} else {
			page = Integer.parseInt(strPage);
		}
		int pageCount = (count+4)/pageLines;
		if (page < 0) {
			page = 0;
		} else if (page >= pageCount) {
			page = pageCount-1;
		}
		PrintWriter out = response.getWriter();
		out.print(page);
		ArrayList<Student> rs = StudentService.searchAllStudent(page, pageLines);
		// HttpSession session = request.getSession();
		request.setAttribute("page", page);
		request.setAttribute("AllStudent", rs);
		request.setAttribute("previous_page", page - 1);
		request.setAttribute("next_page", page + 1);
		request.setAttribute("count", count);
		request.setAttribute("pageLines", pageLines);
		request.getRequestDispatcher("fenye.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
