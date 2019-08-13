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
		// 设置POST接收的编码
		request.setCharacterEncoding("utf-8");
		// 设置out输出的编码
		response.setCharacterEncoding("utf-8");
		// 设置页面编码
		response.setContentType("text/html; charset=UTF-8");
		// 得到数据
		int uno = Integer.parseInt(request.getParameter("uno"));
		// 生成out对象
		PrintWriter out = response.getWriter();
		Student rs = StudentService.searchStudent(uno);
		if (rs!=null) {
			out.print("查找成功" + rs.toString());
		} else {
			out.print("没有该学号的学生");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
