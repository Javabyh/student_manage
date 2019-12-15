package com.iflytek.stumanager.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//���ݿ���Դ������
public class DButil {

	private static Connection conn;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	
	static {
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//ʵ�������ݿ�����conn
	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu_db", "root", "bing");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//ʵ����SQLִ�о��stmt
	public static Statement getStatement() {
		Connection conn = getConnection();
		try {
			if(conn != null) {
				stmt = conn.createStatement();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
	
	//ʵ����SQLִ�о��pstmt
	public static PreparedStatement getPreparedStatement(String sql) {
		Connection conn = getConnection();
		try {
			if(conn != null) {
				pstmt = conn.prepareStatement(sql);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	
	//�ر����ݿ�������Դ
	public static void closeDBResources() {
		try {
			if(pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			if(stmt != null && !stmt.isClosed()) {//���stmt��Ϊ�գ����һ�δ�ر�
				stmt.close();
			}
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
