package com.iflytek.stumanager.business;

import com.iflytek.stumanager.dao.AdminDao;
import com.iflytek.stumanager.po.Admin;

public class AdminService {

	private AdminDao adminDao = new AdminDao();
	//判断管理员密码是否正确
	
	public boolean legal(Admin admin) {
		return adminDao.isExists(admin.getAccount(), admin.getPassword());
	}
}
