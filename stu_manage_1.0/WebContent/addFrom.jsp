<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>添加学生</h2>
	<hr />
	<form action="stuServlet?param=add" method="post">
		<table width="400">
			<tr>
				<td>学号:</td>
				<td><input type="text" name="sno"></td>
			</tr>
			<tr>
				<td>姓名:</td>
				<td><input type="text" name="sname"></td>
			</tr>
			<tr>
				<td>年龄:</td>
				<td><input type="text" name="sage"></td>
			</tr>
			<tr>
				<td>地址:</td>
				<td><input type="text" name="saddress"></td>
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