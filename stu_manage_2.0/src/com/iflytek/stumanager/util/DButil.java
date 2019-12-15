package com.iflytek.stumanager.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//���ݿ���Դ������
public class DButil {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	
	private static DButil instance = new DButil();
	
	private DButil() {
		
	}
	static {
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static DButil getInstance() {
		return instance;
	}
	//ʵ�������ݿ�����conn
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu_db2", "root", "bing");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//ʵ����SQLִ�о��stmt
	public Statement getStatement() {
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
	public PreparedStatement getPreparedStatement(String sql) {
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
	public void closeDBResources() {
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
