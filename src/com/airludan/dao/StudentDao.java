package com.airludan.dao;

import com.airludan.entitis.*;
import java.sql.*;
import java.util.ArrayList;

public class StudentDao {
	// 数据库连接符
	private static final String sqlUrl = "jdbc:mysql://localhost:3366/Student?useUnicode=true&characterEncoding=utf8";
	// 数据库账号
	private static final String sqlUsername = "root";
	// 数据库密码
	private static final String sqlPassword = "admin";
	static {
		try {
			// 加载类
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {

		}
	}

	/*
	 * 判断是否存在相同的学号
	 */
	public static boolean isExist(int uno) {
		boolean result = FindStudentByNO(uno) != null;
		System.out.println(result);
		return result;
	}

	/*
	 * 更改数据
	 */
	public static int updateStudent(int uno, Student stu) {
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			// 链接数据库
			conn = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
			// 设置SQL语句
			String sql = "update stuInfo set name = ?,password = ?,age = ?,hobby = ?,email = ? where number = ? ";
			// 预编译SQL
			pstat = conn.prepareStatement(sql);
			// 填入各种参数
			pstat.setString(1, stu.getName());
			pstat.setString(2, stu.getPassword());
			pstat.setInt(3, stu.getAge());
			pstat.setString(4, stu.getHobby());
			pstat.setString(5, stu.getEmail());
			pstat.setInt(6, uno);
			// 返回得到的结果
			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstat != null)
					pstat.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return 0;
	}

	/*
	 * 增加学生 返回值（int）: 1 增加成功 0 增加失败
	 */
	public static int addStudent(Student stu) {
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			// 链接数据库
			conn = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
			// 设置SQL语句
			String sql = "insert into stuInfo values(?,?,?,?,?,?)";
			// 预编译SQL
			pstat = conn.prepareStatement(sql);
			// 填入各种参数
			pstat.setInt(1, stu.getNo());
			pstat.setString(2, stu.getName());
			pstat.setString(3, stu.getPassword());
			pstat.setInt(4, stu.getAge());
			pstat.setString(5, stu.getHobby());
			pstat.setString(6, stu.getEmail());
			// 返回得到的结果
			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstat != null)
					pstat.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return 0;
	}

	/*
	 * 根据学号删除学生 返回int类型 0:刪除失敗 1刪除成功
	 */
	public static int DelectStudentByNO(int uno) {
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			// 链接数据库
			conn = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
			// 设置SQL语句
			String sql = "delete from stuInfo where Number = ?";
			// 预编译SQL
			pstat = conn.prepareStatement(sql);
			// 填入各种参数
			pstat.setInt(1, uno);
			// 返回得到的结果
			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstat != null)
					pstat.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return 0;
	}

	public static ArrayList<Student> FindAllStudent() {
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		ArrayList<Student> stuList = new ArrayList<Student>();
		try {
			// 链接数据库
			conn = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
			// 填写SQL语句
			String sql = "select * from stuInfo ";
			// 预编译
			pstat = conn.prepareStatement(sql);
			// 返回结果集
			rs = pstat.executeQuery();
			// 填入信息并且返回数据student
			while(rs.next()) {
				int uno = Integer.parseInt(rs.getString("number"));
				String uname = rs.getString("name");
				String upassword = rs.getString("password");
				int uage = rs.getInt("age");
				String uhobby = rs.getString("hobby");
				String uemail = rs.getString("email");
				Student stu = new Student(uno, uname, upassword, uage, uhobby, uemail);
				stuList.add(stu);
			}
			return stuList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstat != null)
					pstat.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return null;

	}
	/*
	 * 	返回学生的个数 int
	 */
	public static int FindStudentCount() {
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		int count = 0;
		try {
			// 链接数据库
			conn = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
			// 填写SQL语句
			String sql = "select count(*) as count from stuInfo ";
			// 预编译
			pstat = conn.prepareStatement(sql);
			// 返回结果集
			rs = pstat.executeQuery();
			// 填入信息并且返回数据student
			if(rs.next()) {
				count = Integer.parseInt(rs.getString("count"));
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstat != null)
					pstat.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return 0;

	}
	
	public static ArrayList<Student> FindAllStudent(int page,int pageLines) {
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		ArrayList<Student> stuList = new ArrayList<Student>();
		try {
			// 链接数据库
			conn = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
			// 填写SQL语句
			String sql = "select * from stuInfo limit ?,?";
			// 预编译
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, page*pageLines);
			pstat.setInt(2, pageLines);
			// 返回结果集
			rs = pstat.executeQuery();
			// 填入信息并且返回数据student
			while(rs.next()) {
				int uno = Integer.parseInt(rs.getString("number"));
				String uname = rs.getString("name");
				String upassword = rs.getString("password");
				int uage = rs.getInt("age");
				String uhobby = rs.getString("hobby");
				String uemail = rs.getString("email");
				Student stu = new Student(uno, uname, upassword, uage, uhobby, uemail);
				stuList.add(stu);
			}
			return stuList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstat != null)
					pstat.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return null;

	}
	

	public static Student FindStudentByNO(int uno) {
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			// 链接数据库
			conn = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
			// 填写SQL语句
			String sql = "select * from stuInfo where number = ?";
			// 预编译
			pstat = conn.prepareStatement(sql);
			// 传入学号
			pstat.setInt(1, uno);
			// 返回结果集
			rs = pstat.executeQuery();
			// 填入信息并且返回数据student
			if (rs.next()) {
				String uname = rs.getString("name");
				String upassword = rs.getString("password");
				int uage = rs.getInt("age");
				String uhobby = rs.getString("hobby");
				String uemail = rs.getString("email");
				Student stu = new Student(uno, uname, upassword, uage, uhobby, uemail);
				return stu;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstat != null)
					pstat.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return null;
	}
}
