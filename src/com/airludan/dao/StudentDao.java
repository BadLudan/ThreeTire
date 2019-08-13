package com.airludan.dao;

import com.airludan.entitis.*;
import java.sql.*;
import java.util.ArrayList;

public class StudentDao {
	// ���ݿ����ӷ�
	private static final String sqlUrl = "jdbc:mysql://localhost:3366/Student?useUnicode=true&characterEncoding=utf8";
	// ���ݿ��˺�
	private static final String sqlUsername = "root";
	// ���ݿ�����
	private static final String sqlPassword = "admin";
	static {
		try {
			// ������
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {

		}
	}

	/*
	 * �ж��Ƿ������ͬ��ѧ��
	 */
	public static boolean isExist(int uno) {
		boolean result = FindStudentByNO(uno) != null;
		System.out.println(result);
		return result;
	}

	/*
	 * ��������
	 */
	public static int updateStudent(int uno, Student stu) {
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			// �������ݿ�
			conn = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
			// ����SQL���
			String sql = "update stuInfo set name = ?,password = ?,age = ?,hobby = ?,email = ? where number = ? ";
			// Ԥ����SQL
			pstat = conn.prepareStatement(sql);
			// ������ֲ���
			pstat.setString(1, stu.getName());
			pstat.setString(2, stu.getPassword());
			pstat.setInt(3, stu.getAge());
			pstat.setString(4, stu.getHobby());
			pstat.setString(5, stu.getEmail());
			pstat.setInt(6, uno);
			// ���صõ��Ľ��
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
	 * ����ѧ�� ����ֵ��int��: 1 ���ӳɹ� 0 ����ʧ��
	 */
	public static int addStudent(Student stu) {
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			// �������ݿ�
			conn = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
			// ����SQL���
			String sql = "insert into stuInfo values(?,?,?,?,?,?)";
			// Ԥ����SQL
			pstat = conn.prepareStatement(sql);
			// ������ֲ���
			pstat.setInt(1, stu.getNo());
			pstat.setString(2, stu.getName());
			pstat.setString(3, stu.getPassword());
			pstat.setInt(4, stu.getAge());
			pstat.setString(5, stu.getHobby());
			pstat.setString(6, stu.getEmail());
			// ���صõ��Ľ��
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
	 * ����ѧ��ɾ��ѧ�� ����int���� 0:�h��ʧ�� 1�h���ɹ�
	 */
	public static int DelectStudentByNO(int uno) {
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			// �������ݿ�
			conn = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
			// ����SQL���
			String sql = "delete from stuInfo where Number = ?";
			// Ԥ����SQL
			pstat = conn.prepareStatement(sql);
			// ������ֲ���
			pstat.setInt(1, uno);
			// ���صõ��Ľ��
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
			// �������ݿ�
			conn = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
			// ��дSQL���
			String sql = "select * from stuInfo ";
			// Ԥ����
			pstat = conn.prepareStatement(sql);
			// ���ؽ����
			rs = pstat.executeQuery();
			// ������Ϣ���ҷ�������student
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
	 * 	����ѧ���ĸ��� int
	 */
	public static int FindStudentCount() {
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		int count = 0;
		try {
			// �������ݿ�
			conn = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
			// ��дSQL���
			String sql = "select count(*) as count from stuInfo ";
			// Ԥ����
			pstat = conn.prepareStatement(sql);
			// ���ؽ����
			rs = pstat.executeQuery();
			// ������Ϣ���ҷ�������student
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
			// �������ݿ�
			conn = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
			// ��дSQL���
			String sql = "select * from stuInfo limit ?,?";
			// Ԥ����
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, page*pageLines);
			pstat.setInt(2, pageLines);
			// ���ؽ����
			rs = pstat.executeQuery();
			// ������Ϣ���ҷ�������student
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
			// �������ݿ�
			conn = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
			// ��дSQL���
			String sql = "select * from stuInfo where number = ?";
			// Ԥ����
			pstat = conn.prepareStatement(sql);
			// ����ѧ��
			pstat.setInt(1, uno);
			// ���ؽ����
			rs = pstat.executeQuery();
			// ������Ϣ���ҷ�������student
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
