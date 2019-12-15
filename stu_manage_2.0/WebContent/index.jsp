<%@ page import="com.iflytek.stumanager.po.Student"%>
<%@ page import="java.util.List"%>
<%@ page import="com.iflytek.stumanager.business.StudentService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function addFrom(){
		window.location.href = "addFrom.jsp";	
	}
	function confirmDel(sno){
		var result = window.confirm("确认删除吗？");
		if(result){
			window.location.href = "stuServlet?param=delete&sno=" + sno;
		}	
	}
</script>
</head>
<body>
	<%
		//查询所有学生数据
		StudentService stuService = new StudentService();
		List<Student> stuList = stuService.findAllStudents();
	%>
	<h2 align="center">学生信息列表</h2>
	<hr />
	
	<table width="800" align="center" > 
		<tr>
		<td align="right"><input type="button" value="添加" onclick="addFrom();"></td>
		</tr>
	</table>
	<table width="800" border="1" align="center">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>地址</th>
			<th>操作</th>
		</tr>	
		<%
			for(Student stu:stuList){
		%>
			<tr>
				<td><%=stu.getSno() %></td>
				<td><%=stu.getSname() %></td>
				<td><%=stu.getSage() %></td>
				<td><%=stu.getSaddress() %></td>
				<td align="center">
				<a href="updateForm.jsp?sno=<%=stu.getSno() %>">修改</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#" onclick="confirmDel(<%=stu.getSno() %>);">删除</a>
				</td>
			</tr>
		<% 
			}
		%>
	</table>
	<hr />
	<a href="stuServlet">其他操作</a>
</body>
</html>