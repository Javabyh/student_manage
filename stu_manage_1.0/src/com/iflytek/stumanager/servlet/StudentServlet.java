package com.iflytek.stumanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iflytek.stumanager.business.StudentService;
import com.iflytek.stumanager.po.Student;

public class StudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3576352644666296342L;
	private StudentService stuService = new StudentService();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String param = request.getParameter("param");

		if ("add".equals(param)) {// ���ѧ��
			int sno = Integer.parseInt(request.getParameter("sno"));
			String sname = request.getParameter("sname");
			int sage = Integer.parseInt(request.getParameter("sage"));
			String saddress = request.getParameter("saddress");

			Student stu = new Student(sno, sname, sage, saddress);

			stuService.saveStudent(stu);

			// �ض���index.jsptҳ��
			response.sendRedirect("index.jsp");
		} else if ("update".equals(param)) {// �޸�ѧ����Ϣ
			int sno = Integer.parseInt(request.getParameter("sno"));
			String sname = request.getParameter("sname");
			int sage = Integer.parseInt(request.getParameter("sage"));
			String saddress = request.getParameter("saddress");

			Student stu = new Student(sno, sname, sage, saddress);
			stuService.updateStudent(stu);

			// �ض���index.jsptҳ��
			response.sendRedirect("index.jsp");
		} else if ("delete".equals(param)) {
			int sno = Integer.parseInt(request.getParameter("sno"));
			stuService.deleteStudent(sno);

			// �ض���index.jsptҳ��
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("other.jsp");
		}
	}

}
