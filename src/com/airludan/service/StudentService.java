package com.airludan.service;

import java.util.*;

import com.airludan.dao.StudentDao;
import com.airludan.entitis.Student;

public class StudentService {

	/*
	 * 增加学生 输入Student对象 输出 true 增加成功 输出false 已存在相同学号
	 */
	public static boolean addStudent(Student stu) {
		// 先判断数据库 如果不存在的学号 就增加
		if (!StudentDao.isExist(stu.getNo())) {
			// 调用dal层addstudent把值传入数据库
			int rs = StudentDao.addStudent(stu);
			if (rs > 0) {
				return true;
			}
		}
		return false;
	}

	public static Student searchStudent(int uno) {
		if (StudentDao.isExist(uno)) {
			// 调用dal层addstudent把值传入数据库
			return  StudentDao.FindStudentByNO(uno);
		}
		return null;
	}
	/*
	 *  找到所有学生 返回是list的student
	 */
	public static ArrayList<Student> searchAllStudent(){
		return StudentDao.FindAllStudent();
	}
	/*
	 *  以分页的方式找到所有学生
	 */
	public static ArrayList<Student> searchAllStudent(int page,int pageLines){
		return StudentDao.FindAllStudent(page,pageLines);
	}
	/*
	 * 	返回所有数据的个数 int
	 */
	public static int searchAllStudentCount() {
		return StudentDao.FindStudentCount();
	}
	/*
	 *  更新学生数据 返回是否修改成功
	 */
	
	public static boolean updateStudent(int uno,Student stu) {
		if (StudentDao.isExist(uno)) {
			// 调用dal层addstudent把值传入数据库
			int rs = StudentDao.updateStudent(uno, stu);
			if (rs > 0) {
				return true;
			}
		}
		return false;
	}
	/*
	 * 	根据传入的学号删除学生
	 */
	public static boolean deleteStudent(int uno) {
		if (StudentDao.isExist(uno)) {
			// 调用dal层addstudent把值传入数据库
			int rs = StudentDao.DelectStudentByNO(uno);
			if (rs > 0) {
				return true;
			}
		}
		return false;
	}
}
