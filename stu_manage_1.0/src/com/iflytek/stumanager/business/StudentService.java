package com.iflytek.stumanager.business;

import java.util.List;

import com.iflytek.stumanager.dao.StudentDao;
import com.iflytek.stumanager.po.Student;

public class StudentService {

	private StudentDao stuDao = new StudentDao();
	//���ѧ��
	public void saveStudent(Student student) {
		stuDao.saveStudent(student);
		
	}
	//�޸�ѧ��
	public void updateStudent(Student student) {
		stuDao.updateStudent(student);
	}
	//ɾ��ѧ��
	public void deleteStudent(int sno) {
		stuDao.deleteStudent(sno);
	}
	//��id��ѯѧ��
	public Student findStudentById(int sno) {
		return stuDao.findStudentById(sno);
	}
	//��ѯ����ѧ��
	public List<Student> findAllStudents(){
		return stuDao.findAllStudents();
	}
}
