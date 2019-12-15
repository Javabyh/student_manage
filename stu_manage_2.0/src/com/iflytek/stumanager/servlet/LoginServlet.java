package com.iflytek.stumanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iflytek.stumanager.business.AdminService;
import com.iflytek.stumanager.po.Admin;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9092894749308483594L;
	
	private AdminService adminService = new AdminService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		Admin admin = new Admin(account,password);
		
		//�жϹ���Ա�Ƿ�Ϸ�
		boolean legal = adminService.legal(admin);
		if(legal) {
			//�ض���index.jsp
			response.sendRedirect("index.jsp");
		}else {
			//�ض���error.jsp
			//response.sendRedirect("error.jsp");
			
			//ת������
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}

}
