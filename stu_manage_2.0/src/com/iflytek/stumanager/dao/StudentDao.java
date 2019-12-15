package com.iflytek.stumanager.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iflytek.stumanager.po.Student;
import com.iflytek.stumanager.util.DButil;


public class StudentDao {


	//添加学生
	public void saveStudent(Student student) {
		String sql = "insert into student(sno,sname,sage,saddress) values(?,?,?,?)";
		PreparedStatement pstmt = DButil.getInstance().getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1,student.getSno());
			pstmt.setString(2,student.getSname());
			pstmt.setInt(3,student.getSage());
			pstmt.setString(4,student.getSaddress());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButil.getInstance().closeDBResources();
		}
	}
	//修改学生
	public void updateStudent(Student student) {
		String sql = "update student set sname = ?,sage = ?,saddress = ? where sno = ? ";
		PreparedStatement pstmt = DButil.getInstance().getPreparedStatement(sql);
		
		try {
			pstmt.setString(1,student.getSname());
			pstmt.setInt(2,student.getSage());
			pstmt.setString(3,student.getSaddress());
			pstmt.setInt(4,student.getSno());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButil.getInstance().closeDBResources();
		}
	}
	//删除学生
	public void deleteStudent(int sno) {
		String sql = "delete from student where sno = ? ";
		PreparedStatement pstmt = DButil.getInstance().getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, sno);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButil.getInstance().closeDBResources();
		}
	}
	//由id查询学生
	public Student findStudentById(int sno) {
		Student stu = null;
		String sql = "select * from student where sno = ?";
	    PreparedStatement pstmt = DButil.getInstance().getPreparedStatement(sql);
	    try {
			pstmt.setInt(1,sno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String sname = rs.getString("sname");
				int sage = rs.getInt("sage");
				String saddress = rs.getString("saddress");
				stu = new Student(sno,sname,sage,saddress);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.getInstance().closeDBResources();
		}
	    return stu;
	}
	//查询所有学生
	public List<Student> findAllStudents(){
		List<Student> stuList = new ArrayList<Student>();
		String sql = "select * from student";
	    PreparedStatement pstmt = DButil.getInstance().getPreparedStatement(sql);
	    try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int sno = rs.getInt("sno");
				String sname = rs.getString("sname");
				int sage = rs.getInt("sage");
				String saddress = rs.getString("saddress");
				Student stu = new Student(sno,sname,sage,saddress);
				stuList.add(stu);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.getInstance().closeDBResources();
		}
	    return stuList;
	}
}
