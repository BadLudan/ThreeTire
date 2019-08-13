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
		// 设置POST接收的编码
		request.setCharacterEncoding("utf-8");
		// 设置out输出的编码
		response.setCharacterEncoding("utf-8");
		// 设置页面编码
		response.setContentType("text/html; charset=UTF-8");
		//得到数据
		int uno = Integer.parseInt(request.getParameter("uno"));
		//生成out对象
		PrintWriter out = response.getWriter();
		boolean rs = StudentService.deleteStudent(uno);
		if(rs) {
			out.print("删除成功");
		}else {
			out.print("删除失败");
		}
		response.sendRedirect("SearchAllStudent");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
