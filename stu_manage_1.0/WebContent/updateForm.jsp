<%@page import="com.iflytek.stumanager.po.Student"%>
<%@page import="com.iflytek.stumanager.business.StudentService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	int sno = Integer.parseInt(request.getParameter("sno"));
	StudentService stuService = new StudentService();
	Student stu = stuService.findStudentById(sno);
%>
</head>
<body>
	<h2>修改学生信息</h2>
	<hr />
	<form action="stuServlet?param=update" method="post">
		<table width="400">
			<tr>
				<td>学号:</td>
				<td><input type="text" name="sno" value="<%=stu.getSno() %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>姓名:</td>
				<td><input type="text" name="sname" value="<%=stu.getSname() %>"></td>
			</tr>
			<tr>
				<td>年龄:</td>
				<td><input type="text" name="sage" value="<%=stu.getSage()%>"></td>
			</tr>
			<tr>
				<td>地址:</td>
				<td><input type="text" name="saddress" value="<%=stu.getSaddress()%>"></td>
			</tr>
			<tr>
				<td colspan="2" >
				<input type="submit" value="提交">
				<input type="reset" value="重置">
				</td>
			</tr>			
		</table>
	</form>
</body>
</html>