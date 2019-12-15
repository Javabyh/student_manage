package com.iflytek.stumanager.business;

import java.util.List;

import com.iflytek.stumanager.dao.StudentDao;
import com.iflytek.stumanager.po.Student;

public class StudentService {

	private StudentDao stuDao = new StudentDao();
	//添加学生
	public void saveStudent(Student student) {
		stuDao.saveStudent(student);
		
	}
	//修改学生
	public void updateStudent(Student student) {
		stuDao.updateStudent(student);
	}
	//删除学生
	public void deleteStudent(int sno) {
		stuDao.deleteStudent(sno);
	}
	//由id查询学生
	public Student findStudentById(int sno) {
		return stuDao.findStudentById(sno);
	}
	//查询所有学生
	public List<Student> findAllStudents(){
		return stuDao.findAllStudents();
	}
}
