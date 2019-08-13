package com.airludan.service;

import java.util.*;

import com.airludan.dao.StudentDao;
import com.airludan.entitis.Student;

public class StudentService {

	/*
	 * ����ѧ�� ����Student���� ��� true ���ӳɹ� ���false �Ѵ�����ͬѧ��
	 */
	public static boolean addStudent(Student stu) {
		// ���ж����ݿ� ��������ڵ�ѧ�� ������
		if (!StudentDao.isExist(stu.getNo())) {
			// ����dal��addstudent��ֵ�������ݿ�
			int rs = StudentDao.addStudent(stu);
			if (rs > 0) {
				return true;
			}
		}
		return false;
	}

	public static Student searchStudent(int uno) {
		if (StudentDao.isExist(uno)) {
			// ����dal��addstudent��ֵ�������ݿ�
			return  StudentDao.FindStudentByNO(uno);
		}
		return null;
	}
	/*
	 *  �ҵ�����ѧ�� ������list��student
	 */
	public static ArrayList<Student> searchAllStudent(){
		return StudentDao.FindAllStudent();
	}
	/*
	 *  �Է�ҳ�ķ�ʽ�ҵ�����ѧ��
	 */
	public static ArrayList<Student> searchAllStudent(int page,int pageLines){
		return StudentDao.FindAllStudent(page,pageLines);
	}
	/*
	 * 	�����������ݵĸ��� int
	 */
	public static int searchAllStudentCount() {
		return StudentDao.FindStudentCount();
	}
	/*
	 *  ����ѧ������ �����Ƿ��޸ĳɹ�
	 */
	
	public static boolean updateStudent(int uno,Student stu) {
		if (StudentDao.isExist(uno)) {
			// ����dal��addstudent��ֵ�������ݿ�
			int rs = StudentDao.updateStudent(uno, stu);
			if (rs > 0) {
				return true;
			}
		}
		return false;
	}
	/*
	 * 	���ݴ����ѧ��ɾ��ѧ��
	 */
	public static boolean deleteStudent(int uno) {
		if (StudentDao.isExist(uno)) {
			// ����dal��addstudent��ֵ�������ݿ�
			int rs = StudentDao.DelectStudentByNO(uno);
			if (rs > 0) {
				return true;
			}
		}
		return false;
	}
}
