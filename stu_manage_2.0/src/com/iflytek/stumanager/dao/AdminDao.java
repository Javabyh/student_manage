package com.iflytek.stumanager.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iflytek.stumanager.util.DButil;

public class AdminDao {

	//≈–∂œ√‹¬Î∫Õ’À∫≈ «∑Ò¥Â‘⁄
	
	public boolean isExists(String account, String password) {
		    boolean isExists = false;	
			String sql = "select * from admin where account=? and password=?";
			PreparedStatement pstmt = DButil.getInstance().getPreparedStatement(sql);
			
			try {
				pstmt.setString(1, account);
				pstmt.setString(2, password);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					isExists = true;
				}
			} catch (SQLException e) {
			
				e.printStackTrace();
			}finally {
				DButil.getInstance().closeDBResources();
			}
			return isExists;
	}
}
